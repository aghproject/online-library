package pl.agh.tons.project.service;

import com.google.gson.Gson;
import com.google.inject.Inject;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.model.Book;
import pl.agh.tons.project.model.Loan;
import pl.agh.tons.project.model.User;

import java.util.List;

/**
 * Created by psk on 07.05.16.
 */
public class LoanServiceImpl implements LoanService {

    private LoanDao loanDao;

    private Gson gson = new Gson();

    @Inject
    public LoanServiceImpl(LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    @Override
    public List<Loan> getLoans(int userId) {
        return loanDao.getByForeignKey("user_id", userId);
    }

    @Override
    public void getReturnBook(Book book, User user) {

    }
}
