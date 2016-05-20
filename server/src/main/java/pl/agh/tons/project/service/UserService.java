package pl.agh.tons.project.service;


import pl.agh.tons.project.model.User;

/**
 * Created by pskurski on 4/14/2016.
 */
public interface UserService {

    String getById(int id);

    String showUsers();

    String showLoans(User user);

    User getByEmailAndPassword(String email, String password);
}
