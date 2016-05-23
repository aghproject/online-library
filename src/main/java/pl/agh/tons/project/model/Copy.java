package pl.agh.tons.project.model;

import javax.persistence.*;

/**
 * Created by psk on 07.05.16.
 */
@Entity
@Table(name="copy")
public class Copy {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", length=11, unique=true)
    private int id;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    public Copy() {}

    public Copy(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
