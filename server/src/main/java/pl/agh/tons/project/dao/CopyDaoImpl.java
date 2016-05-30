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
    public List<Copy> getAllNotRentedBooks() {
        Query query = entityManagerFactory.get().createQuery("from Copy WHERE rented=0");

        return (List<Copy>) query.getResultList();
    }

    @Override
    public void setRented(int copyId) {
        Copy copy = getById(copyId);
        copy.setRented(1);

        entityManagerFactory.get().<Copy>merge(copy);
    }
}
