package pl.agh.tons.project.service;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
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
    public boolean loanBook(int bookId, int userId) {
        List<Copy> copies = copyDao.getNotRentedCopies(bookId);
        if (copies.isEmpty()) {
            return false;
        }

        Copy copyToRent = copies.get(0);
        copyDao.setRented(copyToRent);

        User user = userDao.getById(userId);
        Copy copy = copyDao.getById(bookId);
        Loan newLoan = new Loan(user, copy, new Date(), new Date(), 0);

        loanDao.addLoan(newLoan);
        return true;
    }

    @Override
    @Transactional
    public void returnBook(int copyId, int userId) {
        copyDao.setNotRented(copyId);

        Loan loan = loanDao.getLoan(copyId, userId);
        loan.setArchive(1);

        loanDao.setLoan(loan);

        //todo: check if return date is valid (based on dates in loan table)
        Date expectedReturnDate = loan.getEndDate();
        Date actualReturnDate = new Date();
    }

}
