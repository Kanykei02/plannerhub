package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.AuthModel;
import kg.ItAcademy.plannerhub.repository.UserRepository;
import kg.ItAcademy.plannerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sign-up")
    public User save(@RequestBody User user) throws Exception {
//        Optional<User> userNameCheck = userRepository.findByUsername(user.getUsername());
//        Optional<User> userEmailCheck = userRepository.findByEmail(user.getEmail());
        Optional<User> userNameCheck = userRepository.findByUsername(user.getUsername());
        if (userNameCheck.isPresent()) {
            throw new Exception ("Такой логин уже существует");
        }else{
        return user;}
    }

    @PostMapping("/sign-in")
    public String getToken(@RequestBody AuthModel authModel) {
        return userService.getTokenByAuthModel(authModel);
    }
}
