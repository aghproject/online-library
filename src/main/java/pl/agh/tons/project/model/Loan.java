package pl.agh.tons.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pskurski on 4/14/2016.
 */
@Entity
@Table(name="loan")
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private transient User user;

    @ManyToOne
    @JoinColumn(name="copy_id", nullable = false)
    private Copy copy;

    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    private Date endDate;

    public Loan() {}

    public Loan(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Loan(User user, Copy copy, Date startDate, Date endDate) {
        this.user = user;
        this.copy = copy;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        if (id != loan.id) return false;
        if (!endDate.equals(loan.endDate)) return false;
        if (!startDate.equals(loan.startDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Loanword{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
