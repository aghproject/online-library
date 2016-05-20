package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.AuthorDao;
import pl.agh.tons.project.model.Author;

import javax.persistence.EntityManager;

/**
 * Created by psk on 07.05.16.
 */
public class AuthorDaoImpl extends AbstractDao<Author> implements AuthorDao {

    @Inject
    public AuthorDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
