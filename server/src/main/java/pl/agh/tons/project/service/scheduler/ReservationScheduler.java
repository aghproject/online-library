package pl.agh.tons.project.service.scheduler;

import com.google.inject.persist.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.ReservationDao;
import pl.agh.tons.project.model.Copy;
import pl.agh.tons.project.model.Loan;
import pl.agh.tons.project.model.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by pskurski on 6/1/2016.
 */
public class ReservationScheduler {
    private static final Logger LOG = LoggerFactory.getLogger(ReservationScheduler.class);

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private ScheduledFuture<?> reservationHandler;

    private ReservationDao reservationDao;

    private CopyDao copyDao;

    private LoanDao loanDao;

    public ReservationScheduler(ReservationDao reservationDao,
                                CopyDao copyDao, LoanDao loanDao) {
        this.reservationDao = reservationDao;
        this.copyDao = copyDao;
        this.loanDao = loanDao;
    }

    /**
     * Check reservations by executing job() method every 10 seconds
     */
    public void runTask() {

        final Runnable checkReservation = new Runnable() {
            public void run() {
                job();
            }
        };

        reservationHandler = scheduler.scheduleAtFixedRate(checkReservation, 40, 10, SECONDS);

//        scheduler.schedule(new Runnable() {
//            public void run() {
//                reservationHandler.cancel(true);
//            }
//        }, 60 * 60, SECONDS);
    }

    public void cancelTask() {
        reservationHandler.cancel(true);
    }

    /**
     * Check reservations and update corresponding tables in database
     * Task executed in separate thread in background
     */
    @Transactional
    public void job() {
        LOG.debug("Reservation check starting...");
        LOG.debug("reservationDao: {}", reservationDao);
        LOG.debug("copyDao: {}", copyDao);
        LOG.debug("loanDao: {}", loanDao);

        /* map with bookId -> Reservation pairs */
        Map<Integer, Reservation> reservationsMap = new LinkedHashMap<>();
        LOG.debug("reservationsMap created...");

        List<Reservation> reservations = reservationDao.getAll();
        LOG.debug("reservations list: {}", reservations.toString());
        if (!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                reservationsMap.put(reservation.getBook().getId(), reservation);
            }
        }

        List<Copy> copies = new ArrayList<>();
        if (!reservations.isEmpty()) {
            copies = copyDao.getNotRentedCopies(new ArrayList<>(reservationsMap.keySet()));
        }

        if (!reservations.isEmpty() && !copies.isEmpty()) {
            LOG.debug("reservations map: {}", reservationsMap.toString());
            LOG.debug("copies list: {}", copies.toString());
            persistReservations(copies, reservationsMap);
        }

        LOG.debug("Reservation check ending...");
    }

    private void persistReservations(List<Copy> copies, Map<Integer, Reservation> reservationsMap) {
        LOG.debug("persist reservations ...");
        for (Copy copy : copies) {
            if (reservationsMap.get(copy.getBook().getId()) != null) {
                /* add new loan to database*/
                loanDao.addLoan(
                        new Loan(reservationsMap.get(copy.getBook().getId()).getUser(),
                                copy, new Date(), new Date())
                );
                /* flag copy as rented and persists */
                copy.setRented(1);
                copyDao.setCopy(copy);
                /* delete reservation from database because it's no longer needed */
                reservationDao.removeReservation(reservationsMap.get(copy.getBook().getId()));
            }
        }
    }
}
