package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.FineDao;
import pl.agh.tons.project.model.Fine;

import javax.persistence.EntityManager;

/**
 * Created by psk on 07.05.16.
 */
public class FineDaoImpl extends AbstractDao<Fine> implements FineDao {

    @Inject
    public FineDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
