package pl.agh.tons.project.dao.abstraction;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by pskurski on 4/6/2016.
 */
public abstract class AbstractDao<T> implements Dao<T> {

    protected static Logger LOG;

    protected Class<T> clazz;

    protected Provider<EntityManager> entityManagerFactory;

    @Inject
    public AbstractDao(Provider<EntityManager> entityManagerFactory) {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];

        this.entityManagerFactory = entityManagerFactory;

        LOG = LoggerFactory.getLogger(clazz);
    }


    @Override
    public T getById(int id) {

        Query query = entityManagerFactory.get().createQuery("from "+ clazz.getSimpleName() +" WHERE id = :id");
        query.setParameter("id", id);

        return (T) query.getResultList().get(0);
    }

    @Override
    public List<T> getAll() {

        List<T> list =  entityManagerFactory.get().createQuery("from "+ clazz.getSimpleName() +"").getResultList();

        return list;
    }

    @Override
    public List<T> getByForeignKey(String column, int id) {

        Query query =  entityManagerFactory.get().createQuery("from "+ clazz.getSimpleName() +
                " WHERE "+column+" = :"+column+"");
        query.setParameter(column, id);
        List<T> list = (List<T>) query.getResultList();

        return list;
    }

}
