package pl.agh.tons.project.service;

import pl.agh.tons.project.model.Book;

/**
 * Created by psk on 07.05.16.
 */
public interface BookService {

    void registerBook(Book book);

    void removeBook(Book book);

    Book findBook(String parameter, String value);
}
