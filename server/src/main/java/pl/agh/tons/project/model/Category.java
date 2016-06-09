package pl.agh.tons.project.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pskurski on 4/14/2016.
 */
@Entity
@Table(name="category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="name", length=100, nullable = false)
    private String name;

    @Column(name="desc")
    private String description;

    public Category() {}

    public Category(String name, String description) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
