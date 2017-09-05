package com.tocsyk.models;


import org.springframework.util.StringUtils;

public class Address {

    private int AddressID;
    private String City;
    private String Street;
    private String PostalCode;
    private String House;

    public Address(String city, String street, String house, String postalCode) {
        try {
            setAddressID();
            this.City = city;
            this.Street = street;
            this.PostalCode = postalCode;
            this.House = house;
            this.AddressID = AddressID;
        } catch (Exception aa) {
            System.out.println("Exception has been thrown:" + aa.toString());
            throw aa;
        }
    }

    public int getAddressID() {
        return AddressID;
    }

    private void setAddressID() {
        AddressID = Sequence.getAddressSeq();
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        if (StringUtils.isEmpty(city)) {
            throw new IllegalArgumentException("City");
        } else
            City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        if (StringUtils.isEmpty(street)) {
            throw new IllegalArgumentException("Street");
        } else
            Street = street;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        if (StringUtils.isEmpty(postalCode)) {
            throw new IllegalArgumentException("PostalCode");
        } else
            PostalCode = postalCode;
    }

    public String getHouse() {
        return House;
    }

    public void setHouse(String house) {
        if (StringUtils.isEmpty(house)) {
            throw new IllegalArgumentException("House");
        } else
            House = house;

    }

}
