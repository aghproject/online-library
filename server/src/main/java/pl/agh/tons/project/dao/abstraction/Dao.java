package pl.agh.tons.project.dao.abstraction;

import java.util.List;

/**
 * Created by pskurski on 4/6/2016.
 */
public interface Dao<T> {

    List<T> getAll();

    List<T> getByForeignKey(String column, int id);
}
