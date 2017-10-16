package com.tocsyk.model;

import javax.persistence.*;

@Entity
@Table(name = "hCustomer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="CreditScore")
    private float creditScore;
    @Column(name="Balance")
    private float balance;
    @Column(name="Branch_Customer")
    private int motherBranchID;
    @Column(name="Contact")
    private int contactID;

    public Customer() {
    }

    public Customer(float creditScore, float balance, int motherBranchID, int contactID) {
        this.contactID = contactID;
        this.creditScore = creditScore;
        this.balance = balance;
        this.motherBranchID = motherBranchID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getContact() {
        return contactID;
    }

    public void setContact(int contact) {
        this.contactID = contact;
    }

    public float getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(float creditScore) {
        this.creditScore = creditScore;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getMotherBranch() {
        return motherBranchID;
    }

    public void setMotherBranch(int motherBranch) {
        this.motherBranchID = motherBranch;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", contact=" + ID +
                ", creditScore=" + creditScore +
                ", balance=" + balance +
                ", motherBranch=" + ID +
                '}';
    }
}
