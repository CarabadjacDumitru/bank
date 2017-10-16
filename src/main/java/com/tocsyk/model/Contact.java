package com.tocsyk.model;

import javax.persistence.*;

@Entity
@Table(name = "hContact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Mobile")
    private String mobile;
    @Column(name="Email")
    private String email;
    @Column(name="Telephone")
    private String telephone;
    @Column(name="Contact_Address")
    private int addressID;

    public Contact() {
    }

    public Contact(String mobile, String email, String telephone, int addressID) {
        this.mobile = mobile;
        this.email = email;
        this.telephone = telephone;
        this.addressID = addressID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAddress() {
        return addressID;
    }

    public void setAddress(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "ID=" + ID +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", Address=" + addressID +
                '}';
    }
}
