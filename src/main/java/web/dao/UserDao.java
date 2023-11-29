package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

   List<User> getAllUsera();

   void saveUser(User user);

   User getUser(int id);



   void delUser(int id);
}
