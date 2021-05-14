package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.AuthModel;
import kg.ItAcademy.plannerhub.repository.UserRepository;
import kg.ItAcademy.plannerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sign-up")
    public ResponseEntity save(@RequestBody User user) throws Exception {
        try {
            User user1 = userService.saveWithPasswordEncode(user);
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/sign-in")
    public String getToken(@RequestBody AuthModel authModel) {
        return userService.getTokenByAuthModel(authModel);
    }
}
