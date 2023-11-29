package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsera();

    @Transactional
    void saveUser(User user);

    @Transactional
    User getUser(int id);


    @Transactional
    void deleteUser(int id);

}
