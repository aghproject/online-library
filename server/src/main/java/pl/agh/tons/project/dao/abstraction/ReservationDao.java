package pl.agh.tons.project.dao.abstraction;

import pl.agh.tons.project.model.Reservation;

/**
 * Created by psk on 07.05.16.
 */
public interface ReservationDao extends Dao<Reservation> {

    void addReservation(Reservation reservation);

    void removeReservation(Reservation reservation);

    Reservation getReservation(int userId, int bookId);
}
