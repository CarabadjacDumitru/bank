package com.tocsyk.models;

import java.util.List;

public class Branch {
    private int ID;
    private Contact contact;
    private List<Customer> customerList;
    private Bank motherBank;
    private float balance;


    public Branch(float balance,  Contact contact, Bank motherBank, List<Customer> listCustomer) {
        this.balance = balance;
        this.contact = contact;
        this.motherBank = motherBank;
        this.customerList = listCustomer;
    }

    public Bank getMotherBank() {
        return motherBank;
    }

    public void setMotherBank(Bank motherBank) {
        this.motherBank = motherBank;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
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
