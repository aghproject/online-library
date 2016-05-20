package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.ReservationDao;
import pl.agh.tons.project.model.Reservation;

import javax.persistence.EntityManager;

/**
 * Created by psk on 07.05.16.
 */
public class ReservationDaoImpl extends AbstractDao<Reservation> implements ReservationDao {

    @Inject
    public ReservationDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
