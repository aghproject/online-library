package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.FeedbackDao;
import pl.agh.tons.project.model.Feedback;

import javax.persistence.EntityManager;

/**
 * Created by psk on 07.05.16.
 */
public class FeedbackDaoImpl extends AbstractDao<Feedback> implements FeedbackDao {

    @Inject
    public FeedbackDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
