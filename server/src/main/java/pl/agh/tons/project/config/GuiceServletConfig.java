package pl.agh.tons.project.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import pl.agh.tons.project.dao.*;
import pl.agh.tons.project.dao.abstraction.*;
import pl.agh.tons.project.service.*;
import pl.agh.tons.project.servlet.*;

/**
 * Created by psk on 12.04.16.
 */
public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                install(new JpaPersistModule("JpaModule"));
                filter("/*").through(PersistFilter.class);

                //servlets mapping
                serve("/login").with(LoginServlet.class);
                serve("/loan").with(LoanServlet.class);
                serve("/book").with(BookServlet.class);
                serve("/book/author").with(AuthorServlet.class);
                serve("/book/category").with(CategoryServlet.class);

                //dao bindings
                bind(UserDao.class).to(UserDaoImpl.class);
                bind(CategoryDao.class).to(CategoryDaoImpl.class);
                bind(BookDao.class).to(BookDaoImpl.class);
                bind(LoanDao.class).to(LoanDaoImpl.class);
                bind(AddressDao.class).to(AddressDaoImpl.class);
                bind(AuthorDao.class).to(AuthorDaoImpl.class);
                bind(CopyDao.class).to(CopyDaoImpl.class);
                bind(FeedbackDao.class).to(FeedbackDaoImpl.class);
                bind(FineDao.class).to(FineDaoImpl.class);
                bind(ReservationDao.class).to(ReservationDaoImpl.class);

                //service bindings
                bind(UserService.class).to(UserServiceImpl.class);
                bind(LoanService.class).to(LoanServiceImpl.class);
                bind(BookService.class).to(BookServiceImpl.class);
                bind(WebProtocol.class).to(WebProtocolImpl.class);
            }
        });
    }
}
