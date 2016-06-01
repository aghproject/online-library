package pl.agh.tons.project.service;

import pl.agh.tons.project.model.Loan;

import java.util.List;

/**
 * Created by psk on 07.05.16.
 */
public interface LoanService {

    List<Loan> getLoans(int userId);

    boolean loanBook(int copyId, int userId);

    void returnBook(int copyId, int userId);

}
