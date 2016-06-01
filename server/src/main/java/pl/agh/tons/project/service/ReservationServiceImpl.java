package pl.agh.tons.project.service;

import com.google.inject.Inject;
import pl.agh.tons.project.dao.abstraction.BookDao;
import pl.agh.tons.project.dao.abstraction.ReservationDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.model.Book;
import pl.agh.tons.project.model.Reservation;
import pl.agh.tons.project.model.User;

/**
 * Created by pskurski on 6/1/2016.
 */
public class ReservationServiceImpl implements ReservationService {

    private ReservationDao reservationDao;

    private BookDao bookDao;

    private UserDao userDao;

    @Inject
    public ReservationServiceImpl(ReservationDao reservationDao, BookDao bookDao, UserDao userDao) {
        this.reservationDao = reservationDao;
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public void reserveBook(int userId, int bookId) {
        User user = userDao.getById(userId);
        Book book = bookDao.getById(bookId);
        Reservation reservation = new Reservation(user, book);

        reservationDao.addReservation(reservation);
    }

    @Override
    public void cancelReservation(int userId, int bookId) {
        Reservation reservation = reservationDao.getReservation(userId, bookId);

        reservationDao.removeReservation(reservation);
    }
}
