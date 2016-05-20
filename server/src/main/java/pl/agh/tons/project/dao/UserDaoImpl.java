package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by psk on 11.04.16.
 */
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Inject
    public UserDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {

        Query query = entityManagerFactory.get().createQuery("from User WHERE email=:email AND password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<User> users = (List<User>) query.getResultList();

        if (!users.isEmpty())
            return users.get(0);
        else
            return null;
    }
}
