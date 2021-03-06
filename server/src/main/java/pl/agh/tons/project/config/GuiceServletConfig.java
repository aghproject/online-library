package pl.agh.tons.project.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import pl.agh.tons.project.dao.AddressDaoImpl;
import pl.agh.tons.project.dao.AuthorDaoImpl;
import pl.agh.tons.project.dao.BookDaoImpl;
import pl.agh.tons.project.dao.CategoryDaoImpl;
import pl.agh.tons.project.dao.CopyDaoImpl;
import pl.agh.tons.project.dao.FeedbackDaoImpl;
import pl.agh.tons.project.dao.FineDaoImpl;
import pl.agh.tons.project.dao.LoanDaoImpl;
import pl.agh.tons.project.dao.ReservationDaoImpl;
import pl.agh.tons.project.dao.UserDaoImpl;
import pl.agh.tons.project.dao.abstraction.AddressDao;
import pl.agh.tons.project.dao.abstraction.AuthorDao;
import pl.agh.tons.project.dao.abstraction.BookDao;
import pl.agh.tons.project.dao.abstraction.CategoryDao;
import pl.agh.tons.project.dao.abstraction.CopyDao;
import pl.agh.tons.project.dao.abstraction.FeedbackDao;
import pl.agh.tons.project.dao.abstraction.FineDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.ReservationDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.service.BookService;
import pl.agh.tons.project.service.BookServiceImpl;
import pl.agh.tons.project.service.CopyService;
import pl.agh.tons.project.service.CopyServiceImpl;
import pl.agh.tons.project.service.LoanService;
import pl.agh.tons.project.service.LoanServiceImpl;
import pl.agh.tons.project.service.ReservationService;
import pl.agh.tons.project.service.ReservationServiceImpl;
import pl.agh.tons.project.service.UserService;
import pl.agh.tons.project.service.UserServiceImpl;
import pl.agh.tons.project.servlet.AuthorServlet;
import pl.agh.tons.project.servlet.BookServlet;
import pl.agh.tons.project.servlet.CategoryServlet;
import pl.agh.tons.project.servlet.CopyServlet;
import pl.agh.tons.project.servlet.LoanServlet;
import pl.agh.tons.project.servlet.LoginServlet;
import pl.agh.tons.project.servlet.ReservationServlet;
import pl.agh.tons.project.servlet.ReturnServlet;
import pl.agh.tons.project.servlet.WebProtocol;
import pl.agh.tons.project.servlet.WebProtocolImpl;

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
                serve("/loan/return").with(ReturnServlet.class);
                serve("/book").with(BookServlet.class);
                serve("/copy").with(CopyServlet.class);
                serve("/book/author").with(AuthorServlet.class);
                serve("/book/category").with(CategoryServlet.class);
                serve("/book/reservation").with(ReservationServlet.class);

                //dao bindings
                bind(UserDao.class).to(UserDaoImpl.class);
                bind(CategoryDao.class).to(CategoryDaoImpl.class);
                bind(BookDao.class).to(BookDaoImpl.class);
                bind(CopyDao.class).to(CopyDaoImpl.class);
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
                bind(CopyService.class).to(CopyServiceImpl.class);
                bind(BookService.class).to(BookServiceImpl.class);
                bind(ReservationService.class).to(ReservationServiceImpl.class);
                bind(WebProtocol.class).to(WebProtocolImpl.class);
            }
        });
    }
}
