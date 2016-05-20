package pl.agh.tons.project.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pskurski on 4/14/2016.
 */
@Entity
@Table(name="book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private Author author;

    @Column(name="title", length=100, nullable = false)
    private String title;

    @Column(name="desc")
    private String description;

    public Book() {}

    public Book(Category category, Author author, String title, String description) {
        this.category = category;
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
