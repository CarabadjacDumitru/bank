package com.tocsyk.models;

import com.tocsyk.models.enums.StatusesType;

import java.util.List;
import java.util.ArrayList;

public class Account {

    private int ID;
    private StatusesType accountStatus;
    private List<Contract> contractList;
    private float balance;
    private int creditScore;

    public Account(float accountBalance, int accountCreditScore, StatusesType accountStatus) {
        this.accountStatus = accountStatus;
        this.balance = accountBalance;
        this.contractList = new ArrayList<>();
        this.creditScore = accountCreditScore;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public StatusesType getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(StatusesType accountStatus) {
        this.accountStatus = accountStatus;
    }

}
