package pl.agh.tons.project.config;

import pl.agh.tons.project.scheduler.ReservationScheduler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by pskurski on 6/1/2016.
 *
 * @WebListener annotation can be used instead of <listener></listener> in web.xml from Servlet 3.0
 */
public class TaskContextListener implements ServletContextListener {

    private ReservationScheduler reservationScheduler;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");

        reservationScheduler = new ReservationScheduler();
        reservationScheduler.runTask();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");

        // todo: add method to cancel reservationScheduler
    }
}
