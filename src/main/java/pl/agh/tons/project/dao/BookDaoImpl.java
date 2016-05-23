package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.BookDao;
import pl.agh.tons.project.model.Book;

import javax.persistence.EntityManager;

/**
 * Created by pskurski on 4/14/2016.
 */
public class BookDaoImpl extends AbstractDao<Book> implements BookDao {

    @Inject
    public BookDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
