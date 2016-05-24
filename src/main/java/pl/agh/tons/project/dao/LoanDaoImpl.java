package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.model.Loan;

import javax.persistence.EntityManager;

/**
 * Created by pskurski on 4/14/2016.
 */
public class LoanDaoImpl extends AbstractDao<Loan> implements LoanDao {

    @Inject
    public LoanDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}