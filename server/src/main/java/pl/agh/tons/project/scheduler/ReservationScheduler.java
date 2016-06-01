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

    /**
     * Check reservations every 10 seconds and update reservation and loan table in database
     */
    public void runTask() {

        final Runnable checkReservation = new Runnable() {
            public void run() {
                job();
            }
        };

        final ScheduledFuture<?> reservationHandler = scheduler.scheduleAtFixedRate(checkReservation, 10, 10, SECONDS);

        scheduler.schedule(new Runnable() {
            public void run() {
                reservationHandler.cancel(true);
            }
        }, 60 * 60, SECONDS);
    }

    public void job() {
        LOG.debug("Execution of scheduled task!");

        // todo: get reservations from database
        // todo: get copies from database
        // todo: check if some copy is available for user, if so update tables in database, if not do nothing
    }
}
