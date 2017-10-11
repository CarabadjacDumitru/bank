package com.tocsyk.models;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private int ID;
    private Contact contact;
    private List<Customer> customerList;
    private float balance;

    public Branch(Contact contact) {
            this.contact = contact;
            customerList = new ArrayList<Customer>();
    }

    public Contact getAddress() {
        return contact;
    }

    public void setAddress(Contact contact) {
        this.contact = contact;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    private void setID(int ID) {
        this.ID = ID;
    }

 }
