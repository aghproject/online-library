package pl.agh.tons.project.model;

import javax.persistence.*;

/**
 * Created by psk on 07.05.16.
 */
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    public Reservation() {}

    public Reservation(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}