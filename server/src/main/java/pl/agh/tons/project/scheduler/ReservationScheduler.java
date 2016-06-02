package pl.agh.tons.project.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.*;

/**
 * Created by pskurski on 6/1/2016.
 */
public class ReservationScheduler {
    private static final Logger LOG = LoggerFactory.getLogger(ReservationScheduler.class);

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private ScheduledFuture<?> reservationHandler;
    /**
     * Check reservations by executing job() method every 10 seconds
     */
    public void runTask() {

        final Runnable checkReservation = new Runnable() {
            public void run() {
                job();
            }
        };

        reservationHandler = scheduler.scheduleAtFixedRate(checkReservation, 10, 10, SECONDS);

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
     * Task executed in background
     */
    private void job() {
        LOG.debug("Reservation check starting...");

        // todo: get reservations from database
        // todo: get copies from database
        // todo: check if some copy is available for user, if so update tables in database, if not do nothing
    }
}
