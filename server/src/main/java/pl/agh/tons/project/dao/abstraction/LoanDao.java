package pl.agh.tons.project.dao.abstraction;

import pl.agh.tons.project.model.Loan;

/**
 * Created by pskurski on 4/14/2016.
 */
public interface LoanDao extends Dao<Loan> {
    void addLoan(Loan loan);

    void setLoan(Loan loan);
}
