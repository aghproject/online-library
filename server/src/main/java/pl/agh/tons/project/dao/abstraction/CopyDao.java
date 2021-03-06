package pl.agh.tons.project.dao.abstraction;

import pl.agh.tons.project.model.Copy;

import java.util.List;

/**
 * Created by psk on 07.05.16.
 */
public interface CopyDao extends Dao<Copy> {
    List<Copy> getAllNotRentedCopies();

    void setRented(Copy copy);

    void setNotRented(int copyId);

    List<Copy> getNotRentedCopies(int bookId);

    List<Copy> getNotRentedCopies(List<Integer> bookIds);

    void setCopy(Copy copy);
}
