package pl.agh.tons.project.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by psk on 07.05.16.
 */
@Entity
@Table(name="address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(name="street", length=45, nullable=true)
    private String name;

    @Column(name="building_num", length=45, nullable=true)
    private String buildingNum;

    @Column(name="local_num", length=45, nullable=true)
    private String localNum;

    @Column(name="zipcode", length=45, nullable=true)
    private String zipcode;

    @Column(name="city", length=45, nullable=true)
    private String city;

    @Column(name="country", length=45, nullable=true)
    private String country;

    public Address() {}

    public Address(User user, String name, String buildingNum,
                   String localNum, String zipcode, String city, String country) {
        this.user = user;
        this.name = name;
        this.buildingNum = buildingNum;
        this.localNum = localNum;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getLocalNum() {
        return localNum;
    }

    public void setLocalNum(String localNum) {
        this.localNum = localNum;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
