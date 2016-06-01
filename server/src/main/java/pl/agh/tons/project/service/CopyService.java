package pl.agh.tons.project.service;

import pl.agh.tons.project.model.Book;
import pl.agh.tons.project.model.Copy;
import pl.agh.tons.project.model.Loan;
import pl.agh.tons.project.model.User;

import java.util.List;

/**
 * Created by psk on 30.05.16.
 */
public interface CopyService {
    List<Copy> getAllNotRentedBooks();
}
