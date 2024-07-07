package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDaoImp;
import web.models.User;

import java.util.List;
@Service

public class UserServiceImp implements UserService {
    @Autowired
    private UserDaoImp userDaoImp;

    @Transactional
    @Override
    public void addNewUser(User user) {
        userDaoImp.addNewUser(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDaoImp.getUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDaoImp.updateUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        userDaoImp.deleteUser(id);

    }
}
