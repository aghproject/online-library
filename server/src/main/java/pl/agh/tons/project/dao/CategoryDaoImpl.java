package pl.agh.tons.project.dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import pl.agh.tons.project.dao.abstraction.AbstractDao;
import pl.agh.tons.project.dao.abstraction.CategoryDao;
import pl.agh.tons.project.model.Category;

import javax.persistence.EntityManager;

/**
 * Created by pskurski on 4/14/2016.
 */
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    @Inject
    public CategoryDaoImpl(Provider<EntityManager> entityManagerFactory) {
        super(entityManagerFactory);
    }
}
