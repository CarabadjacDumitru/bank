package com.tocsyk.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    protected int ID;
    protected Contact contact;
    protected int creditScore;
    protected List<Account> accountList;

    public Customer(int ID, int creditScore, Contact customerContact) {
            this.ID = ID;
            this.creditScore = creditScore;
            this.contact = customerContact;
            this.accountList = new ArrayList<Account>();
    }

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Contact getContact() {return contact;}

    public void setContact(Contact contact) {this.contact = contact;}

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

}
