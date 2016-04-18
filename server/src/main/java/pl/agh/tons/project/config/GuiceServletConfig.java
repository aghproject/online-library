package pl.agh.tons.project.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import pl.agh.tons.project.dao.BookDaoImpl;
import pl.agh.tons.project.dao.CategoryDaoImpl;
import pl.agh.tons.project.dao.LoanDaoImpl;
import pl.agh.tons.project.dao.abstraction.BookDao;
import pl.agh.tons.project.dao.abstraction.CategoryDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.dao.UserDaoImpl;
import pl.agh.tons.project.service.UserService;
import pl.agh.tons.project.service.UserServiceImpl;
import pl.agh.tons.project.servlet.UserServlet;

/**
 * Created by psk on 12.04.16.
 */
public class GuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                //servlets mapping
                serve("/member").with(UserServlet.class);
                serve("/member/loans").with(UserServlet.class);

                //dao bindings
                bind(UserDao.class).to(UserDaoImpl.class);
                bind(CategoryDao.class).to(CategoryDaoImpl.class);
                bind(BookDao.class).to(BookDaoImpl.class);
                bind(LoanDao.class).to(LoanDaoImpl.class);

                //service bindings
                bind(UserService.class).to(UserServiceImpl.class);
            }
        });
    }
}