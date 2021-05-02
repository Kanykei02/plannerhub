package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> getAllUsers();
    User findById(Long id);
    User deleteById(Long id);
    List<User> deleteAllUsers();
}
