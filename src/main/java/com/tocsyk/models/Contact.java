package com.tocsyk.models;


public class Contact {

    private int ID;
    private String email;
    private String telephone;
    private String mobile;
    private Address address;

    public Contact(String mobile, String telephone, String email, Address address) {
            this.mobile = mobile;
            this.telephone = telephone;
            this.email = email;
            this.address = address;
            this.ID = ID;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}