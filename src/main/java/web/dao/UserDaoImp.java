package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
//   private final SessionFactory sessionFactory;
@PersistenceContext()
private EntityManager entityManager;




   @Override
   public List<User> getAllUsera() {
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
