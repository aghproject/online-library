package pl.agh.tons.project.config;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.sun.javafx.tk.Toolkit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.agh.tons.project.dao.CopyDaoImpl;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.ReservationDao;
import pl.agh.tons.project.service.scheduler.ReservationScheduler;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by pskurski on 6/1/2016.
 *
 * @WebListener annotation can be used instead of <listener></listener> in web.xml from Servlet 3.0
 */
public class TaskContextListener implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(TaskContextListener.class);

    private ReservationScheduler reservationScheduler;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("Starting web application...");

        Injector injector = (Injector) servletContextEvent.getServletContext()
                .getAttribute(Injector.class.getName());

        CopyDao copyDao = injector.getInstance(CopyDaoImpl.class);
        LoanDao loanDao = injector.getInstance(LoanDao.class);
        ReservationDao reservationDao = injector.getInstance(ReservationDao.class);

        reservationScheduler = new ReservationScheduler(reservationDao, copyDao, loanDao);
        reservationScheduler.runTask();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOG.info("Shutting down web application...");

//        reservationScheduler.cancelTask();
    }
}
