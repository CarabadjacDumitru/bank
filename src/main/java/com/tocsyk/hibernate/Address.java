package com.tocsyk.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "hAddress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="City")
    private String city;
    @Column(name="Street")
    private String street;
    @Column(name="House")
    private String house;
    @Column(name="PostalCode")
    private String postalCode;

    public Address() {
    }

    public Address(String city, String street, String house, String postalCode) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.postalCode = postalCode;
    }


    @OneToOne
    @JoinTable(name = "hContact", joinColumns = {@JoinColumn(name = "ID")})
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "ID=" + ID +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
