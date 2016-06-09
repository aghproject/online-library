package pl.agh.tons.project.service;

/**
 * Created by pskurski on 6/1/2016.
 */
public interface ReservationService {

    void reserveBook(int userId, int bookId);

    void cancelReservation(int userId, int bookId);
}
