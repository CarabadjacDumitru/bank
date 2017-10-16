package com.tocsyk.model;


import javax.persistence.*;

@Entity
@Table(name = "hAccount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="CreditScore")
    private float creditScore;
    @Column(name="Balance")
    private float balance;
    @Column(name="Account_status")
    private int statusTypeID;
    @Column(name="Customer_account")
    private int  motherAccountID;


    public Account() {
    }

    public Account(float creditScore, float balance, int customerAccountID, int statusTypeID) {
        this.creditScore = creditScore;
        this.balance = balance;
        this.motherAccountID = customerAccountID;
        this.statusTypeID = statusTypeID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getCustomerAccount() {
        return motherAccountID;
    }

    public void setCustomerAccount(int customerAccount) {
        this.motherAccountID = customerAccount;
    }

    public int getAccountStatusType() {
        return statusTypeID;
    }

    public void setAccountStatusType(int accountStatusType) {
        this.statusTypeID = accountStatusType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", creditScore=" + creditScore +
                ", balance=" + balance +
                ", customerAccount=" + motherAccountID +
                ", statusType=" + statusTypeID +
                '}';
    }
}
