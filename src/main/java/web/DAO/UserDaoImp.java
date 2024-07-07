package web.DAO;


import org.springframework.stereotype.Repository;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{

@PersistenceContext
private EntityManager em;

    @Override
    public void addNewUser(User user) {
        em.persist(user);

    }

    @Override
    public List<User> getAllUsers() {
        String sql = "select u from User u";
        TypedQuery<User> query = em.createQuery(sql, User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(int id) {
      return em.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);

    }

    @Override
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));

    }
}
