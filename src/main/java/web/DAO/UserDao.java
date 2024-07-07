package web.DAO;


import web.models.User;
import java.util.List;

public interface UserDao {
   void addNewUser(User user);
   List<User> getAllUsers();
   User getUser(int id);
   void updateUser(User user);
   void deleteUser(int id);
}
