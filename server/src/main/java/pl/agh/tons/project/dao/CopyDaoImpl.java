package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.model.Copy;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by psk on 07.05.16.
 */
public class CopyDaoImpl extends AbstractDao<Copy> implements CopyDao {

    @Inject
    public CopyDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public List<Copy> getAllNotRentedCopies() {
        Query query = entityManagerFactory.get().createQuery("from Copy WHERE rented=0");

        return (List<Copy>) query.getResultList();
    }

    @Override
    public void setRented(Copy copy) {
        copy.setRented(1);

        entityManagerFactory.get().<Copy>merge(copy);
    }

    @Override
    public void setNotRented(int copyId) {
        Copy copy = getById(copyId);
        copy.setRented(0);

        entityManagerFactory.get().<Copy>merge(copy);
    }

    @Override
    public List<Copy> getNotRentedCopies(int bookId) {
        Query query = entityManagerFactory.get().createQuery("from Copy WHERE rented=0 AND book.id = :bookId");
        query.setParameter("bookId", bookId);

        return (List<Copy>) query.getResultList();
    }

    @Override
    public List<Copy> getNotRentedCopies(List<Integer> bookIds) {
        StringBuilder sql = new StringBuilder("from Copy WHERE ");
        String or = "";
        for (int i=0; i<bookIds.size(); i++) {
            sql.append(or);
            sql.append("book.id = :bookId" + i);
            or = " OR ";
        }

        Query query = entityManagerFactory.get().createQuery(sql.toString());
        for (int i=0; i<bookIds.size(); i++) {
            query.setParameter("bookId"+i, bookIds.get(i));
        }

        return (List<Copy>) query.getResultList();
    }

    @Override
    public void setCopy(Copy copy) {
        entityManagerFactory.get().merge(copy);
    }
}
