package pl.agh.tons.project.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by psk on 07.05.16.
 */
@Entity
@Table(name="fine")
public class Fine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", length=11)
    private int id;

    @OneToOne
    @JoinColumn(name="copy_id", nullable=false)
    private Copy copy;

    @Temporal(TemporalType.DATE)
    @Column(name="due_date")
    private Date dueDate;

    @Temporal(TemporalType.DATE)
    @Column(name="in_date")
    private Date inDate;

    @Column(name="value", length=45, nullable=true)
    private BigDecimal value;

    @Column(name="paid", nullable=true)
    private int paid;

    public Fine() {}

    public Fine(Copy copy, Date dueDate, Date inDate, BigDecimal value, int paid) {
        this.copy = copy;
        this.dueDate = dueDate;
        this.inDate = inDate;
        this.value = value;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }
}
