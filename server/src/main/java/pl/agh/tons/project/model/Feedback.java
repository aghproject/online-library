package pl.agh.tons.project.model;

import javax.persistence.*;

/**
 * Created by psk on 07.05.16.
 */
@Entity
@Table(name="feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", length=11)
    private int id;

    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(name="comment")
    private String comment;

    @Column(name="rate", length=11, nullable=true)
    private int rate;

    public Feedback() {}

    public Feedback(User user, String comment, int rate) {
        this.user = user;
        this.comment = comment;
        this.rate = rate;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
