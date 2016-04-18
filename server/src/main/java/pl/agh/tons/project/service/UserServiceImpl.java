package pl.agh.tons.project.service;

import com.google.gson.Gson;
import com.google.inject.Inject;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.model.Loan;
import pl.agh.tons.project.model.User;

import java.util.List;

/**
 * Created by pskurski on 4/14/2016.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private LoanDao loanDao;

    @Inject
    public UserServiceImpl(UserDao userDao, LoanDao loanDao) {
        this.userDao = userDao;
        this.loanDao = loanDao;
    }

    @Override
    public String showUsers() {
        List<User> users = userDao.getAll();

        Gson gson = new Gson();
        String json = gson.toJson(users);

        return json;
    }

    @Override
    public String showLoans(User user) {
        List<Loan> loans = loanDao.getByForeignKey("user_id", user.getId());

        Gson gson = new Gson();
        String json = gson.toJson(loans);

        return json;
    }
}
