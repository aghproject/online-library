package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.model.Loan;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by pskurski on 4/14/2016.
 */
public class LoanDaoImpl extends AbstractDao<Loan> implements LoanDao {

    @Inject
    public LoanDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void addLoan(Loan loan) {
        entityManagerFactory.get().persist(loan);
    }

    @Override
    public void setLoan(Loan loan) {
        entityManagerFactory.get().merge(loan);
    }

    @Override
    public Loan getLoan(int copyId, int userId) {
        Query query = entityManagerFactory.get().createQuery("from Loan WHERE copy.id = :copyId AND " +
                "user.id = :userId");
        query.setParameter("copyId", copyId);
        query.setParameter("userId", userId);

        return (Loan) query.getResultList().get(0);
    }

    @Override
    public List<Loan> getByForeignKey(String column, int id) {

        Query query =  entityManagerFactory.get().createQuery("from "+ clazz.getSimpleName() +
                " WHERE "+column+" = :"+column+" AND archive = 0");
        query.setParameter(column, id);
        List<Loan> list = (List<Loan>) query.getResultList();

        return list;
    }
}
