package pl.agh.tons.project.config;

import com.sun.istack.internal.logging.Logger;
import pl.agh.tons.project.service.scheduler.ReservationScheduler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by pskurski on 6/1/2016.
 *
 * @WebListener annotation can be used instead of <listener></listener> in web.xml from Servlet 3.0
 */
public class TaskContextListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(TaskContextListener.class);

    private ReservationScheduler reservationScheduler;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("Starting web application...");

        reservationScheduler = new ReservationScheduler();
        reservationScheduler.runTask();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOG.info("Shutting down web application...");

        reservationScheduler.cancelTask();
    }
}
