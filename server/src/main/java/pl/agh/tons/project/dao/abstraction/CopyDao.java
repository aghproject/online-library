package pl.agh.tons.project.dao.abstraction;

import pl.agh.tons.project.model.Copy;

import java.util.List;

/**
 * Created by psk on 07.05.16.
 */
public interface CopyDao extends Dao<Copy> {
    List<Copy> getAllNotRentedBooks();

    void setRented(int copyId);

    void setNotRented(int copyId);
}
