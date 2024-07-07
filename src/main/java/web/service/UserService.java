package web.service;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.List;
@Component
public interface UserService {
    void addNewUser(User user);
    List<User> getAllUsers();
    User getUser(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
