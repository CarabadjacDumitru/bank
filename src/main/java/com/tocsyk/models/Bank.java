package com.tocsyk.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private int ID;
    private Contact contact;
    private String name;
    private List<Branch> branchList;
    private float balance;


    public Bank(String name, Contact contact) {
        this.name = name;
        this.contact = contact;
        this.branchList = new ArrayList<>();
        this.balance = 0;
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
}

