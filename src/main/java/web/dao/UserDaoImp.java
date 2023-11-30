package web.dao;


import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
@PersistenceContext()
private EntityManager entityManager;




   @Override
   public List<User> getAllUsers() {
       return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
   }

   @Override
   public void saveUser(User user) {
      if (user.getId() == 0) {
         entityManager.persist(user);
      } else {
         entityManager.merge(user);
      }
      entityManager.close();
   }

   @Override
   public User getUser(int id) {
      return entityManager.find(User.class, id);
   }


   @Override
   public void delUser(int id) {
      System.out.println("ДАО" + id);
      User user = entityManager.find(User.class, id);
      System.out.println("ДАО Юзер " + user);
      if (user != null) {
         entityManager.remove(user);
      }
      entityManager.close();
   }


}
