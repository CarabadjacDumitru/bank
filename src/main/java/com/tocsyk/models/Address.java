package com.tocsyk.models;


public class Address {

    private int ID;
    private String city;
    private String street;
    private String house;
    private String postalCode;

    public Address(String city, String street, String house, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.house = house;
    }

    public int getID() {
        return ID;
    }

    private void setID(int ID) {
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

}
