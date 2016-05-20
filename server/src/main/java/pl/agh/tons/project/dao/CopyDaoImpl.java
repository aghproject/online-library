package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.model.Copy;

import javax.persistence.EntityManager;

/**
 * Created by psk on 07.05.16.
 */
public class CopyDaoImpl extends AbstractDao<Copy> implements CopyDao {

    @Inject
    public CopyDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
