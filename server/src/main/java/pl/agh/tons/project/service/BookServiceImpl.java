package pl.agh.tons.project.service;

import com.google.gson.Gson;
import com.google.inject.Inject;
import pl.agh.tons.project.dao.abstraction.BookDao;
import pl.agh.tons.project.dao.abstraction.LoanDao;
import pl.agh.tons.project.dao.abstraction.UserDao;
import pl.agh.tons.project.model.Book;

import java.util.List;

/**
 * Created by psk on 07.05.16.
 */
public class BookServiceImpl implements BookService {

    private UserDao userDao;
    private BookDao bookDao;

    private Gson gson = new Gson();

    @Inject
    public BookServiceImpl(UserDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public void registerBook(Book book) {

    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public Book findBook(String parameter, String value) {
        return null;
    }
}
