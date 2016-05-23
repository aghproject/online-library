package pl.agh.tons.project.service;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.model.Loan;
import pl.agh.tons.project.model.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by pskurski on 4/14/2016.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private LoanDao loanDao;

    private Gson gson = new Gson();

    @Inject
    public UserServiceImpl(UserDao userDao, LoanDao loanDao) {
        this.userDao = userDao;
        this.loanDao = loanDao;
    }

    @Override
    public String getById(int id) {
        User user = userDao.getById(id);

        return gson.toJson(user);
    }


    @Override
    public String showUsers() {
        List<User> users = userDao.getAll();

        return gson.toJson(users);
    }

    @Override
    public String showLoans(User user) {
        List<Loan> loans = loanDao.getByForeignKey("user_id", user.getId());

        return gson.toJson(loans);
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        return userDao.getByEmailAndPassword(email, password);
    }
}
