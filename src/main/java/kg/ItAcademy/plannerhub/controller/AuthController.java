package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.AuthModel;
import kg.ItAcademy.plannerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public User save(@RequestBody User user) {
        return userService.saveWithPasswordEncode(user);
    }

    @PostMapping("/sign-in")
    public String getToken(@RequestBody AuthModel authModel) {
        return userService.getTokenByAuthModel(authModel);
    }
}
