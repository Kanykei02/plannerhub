package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.User;
import kg.ItAcademy.plannerhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createOrUpdate(User user){
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
        User user = (User) getAllUsers();
        if(user != null){
            userRepository.deleteAll((Iterable<? extends User>) user);
        }
        return null;
    }
}