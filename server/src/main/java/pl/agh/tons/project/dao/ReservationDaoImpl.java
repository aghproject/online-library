package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.ReservationDao;
import pl.agh.tons.project.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by psk on 07.05.16.
 */
@Singleton
public class ReservationDaoImpl extends AbstractDao<Reservation> implements ReservationDao {

    @Inject
    public ReservationDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void addReservation(Reservation reservation) {
        entityManagerFactory.get().persist(reservation);
    }

    @Override
    public void removeReservation(Reservation reservation) {
        entityManagerFactory.get().merge(reservation);
        entityManagerFactory.get().remove(reservation);
    }

    @Override
    public Reservation getReservation(int userId, int bookId) {
        Query query = entityManagerFactory.get().createQuery("from Reservation WHERE user.id = :userId AND" +
                " book.id = :bookId");
        query.setParameter("userId", userId);
        query.setParameter("bookId", bookId);

        return (Reservation) query.getResultList().get(0);
    }
}
