package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.entity.UserRole;
import kg.ItAcademy.plannerhub.model.AuthModel;
import kg.ItAcademy.plannerhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleService userRoleService;


    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public User saveWithPasswordEncode(User user) throws Exception {
        Optional<User> userNameCheck = userRepository.findByUsername(user.getUsername());
        Optional<User> userOpt = userRepository.findById(user.getId());
        if (userNameCheck.isPresent()) {
            throw new Exception("Такой логин уже существует");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleService.save(userRole);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public String getTokenByAuthModel(AuthModel authModel) {
        String authResult = "";
        User user = findByUsername(authModel.getUsername());
        if(user == null) authResult = "Неверный логин/пароль";
        else {
            if(passwordEncoder.matches(authModel.getPassword(), user.getPassword())) {
                String loginPassPair = user.getUsername() + ":" + authModel.getPassword();
                authResult = "Basic " + Base64.getEncoder().encodeToString(loginPassPair.getBytes());
            } else authResult = "Неверный логин/пароль";
        }
        return authResult;
    }

    @Override
    public List<User> getAllUsers(){
        try {
            System.out.println("Пользователь: " + SecurityContextHolder.getContext().getAuthentication().getName());
        } catch (NullPointerException ignored){}

        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }



    @Override
    public User deleteById(Long id){
        User user = findById(id);
        if (user != null){
            userRepository.delete(user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> deleteAllUsers(){
        List<User> user = getAllUsers();
        if(user != null){
            userRepository.deleteAll(user);
        }
        return null;
    }
}
