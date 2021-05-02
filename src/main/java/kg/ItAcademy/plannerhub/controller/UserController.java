package kg.ItAcademy.plannerhub.controller;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createOrUpdate(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @DeleteMapping("/{userId}")
    public User deleteById(@PathVariable Long userId){
        return userService.deleteById(userId);
    }

    @DeleteMapping
    public List<User> deleteAllUsers(){
        return userService.deleteAllUsers();
    }
}
