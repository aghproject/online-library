package pl.agh.tons.project.service.scheduler;

import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pskurski on 6/3/2016.
 */
public class ReservationSchedulerTest {

    private ReservationScheduler reservationScheduler;

    @Inject
    public void setReservationScheduler(ReservationScheduler reservationScheduler) {
        this.reservationScheduler = reservationScheduler;
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testJob_ShouldCheckDbInSeparateThread() throws Exception {
        System.out.println("reservation: " + reservationScheduler);
    }
}
