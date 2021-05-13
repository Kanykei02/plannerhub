package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.model.AuthModel;

import java.util.List;

public interface UserService {
    User saveWithPasswordEncode(User user) throws Exception;
    User save(User user);
    List<User> getAllUsers();
    User findById(Long id);
    User findByUsername(String username);
    String getTokenByAuthModel(AuthModel authModel);
    User deleteById(Long id);
    List<User> deleteAllUsers();
}
