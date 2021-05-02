package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
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
