package pl.agh.tons.project.dao.abstraction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.agh.tons.project.config.HibernateUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by pskurski on 4/6/2016.
 */
public abstract class AbstractDao<T> implements Dao<T> {

    private static Logger LOG;

    protected Class<T> clazz;

    public AbstractDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];

        LOG = LoggerFactory.getLogger(clazz);
    }

    @Override
    public List<T> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<T> list =  session.createQuery("from "+ clazz.getSimpleName() +"").list();

        session.getTransaction().commit();

        //terminate session factory, otherwise program won't end
//        sessionFactory.close();

        return list;
    }

    @Override
    public List<T> getByForeignKey(String column, int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Query query =  session.createQuery("from "+ clazz.getSimpleName() +
                " WHERE "+column+" = :"+column+"");
        query.setParameter(column, id);
        List<T> list = query.list();

        session.getTransaction().commit();

        //terminate session factory, otherwise program won't end
//        sessionFactory.close();

        return list;
    }

}
