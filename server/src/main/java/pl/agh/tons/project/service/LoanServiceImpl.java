package pl.agh.tons.project.service;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.model.Book;
import pl.agh.tons.project.model.Copy;
import pl.agh.tons.project.model.Loan;
import pl.agh.tons.project.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by psk on 07.05.16.
 */
public class LoanServiceImpl implements LoanService {

    private LoanDao loanDao;

    private CopyDao copyDao;

    private UserDao userDao;

    private Gson gson = new Gson();

    @Inject
    public LoanServiceImpl(LoanDao loanDao, CopyDao copyDao, UserDao userDao) {
        this.loanDao = loanDao;
        this.copyDao = copyDao;
        this.userDao = userDao;
    }

    @Override
    public List<Loan> getLoans(int userId) {
        return loanDao.getByForeignKey("user_id", userId);
    }

    @Override
    @Transactional
    public void loanBook(int copyId, int userId) {
        copyDao.setRented(copyId);

        User user = userDao.getById(userId);
        Copy copy = copyDao.getById(copyId);
        Loan newLoan = new Loan(user, copy, new Date(), new Date(), 0);

        loanDao.addLoan(newLoan);
    }

    @Override
    @Transactional
    public void returnBook(int copyId, int userId) {
        copyDao.setNotRented(copyId);

        User user = userDao.getById(userId);
        Copy copy = copyDao.getById(copyId);
        Loan loan = new Loan(user, copy, new Date(), new Date(), 1);

        loanDao.setLoan(loan);
        //todo: check if return date is valid (based on dates in loan table)
    }

}
