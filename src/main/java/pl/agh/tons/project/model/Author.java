package pl.agh.tons.project.model;

import javax.persistence.*;

/**
 * Created by psk on 07.05.16.
 */
@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", length=11, nullable=false, unique=true)
    private int id;

    @Column(name="name", length=45, nullable=true)
    private String name;

    @Column(name="lastName", length=45, nullable=true)
    private String lastName;

    @Column(name="desc")
    private String description;

    public Author() {}

    public Author(String name, String lastName, String description) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
