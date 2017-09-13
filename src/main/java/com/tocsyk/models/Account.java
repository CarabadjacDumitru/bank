package com.tocsyk.models;

import com.tocsyk.models.enums.StatusesType;

import java.util.List;
import java.util.ArrayList;

public class Account {

    private int AccountID;
    private StatusesType AccountStatus;
    private List<Contract> ContractCollection;
    private double AccountBalance;
    private int AccountCreditScore;

    public Account(double accountBalance, int accountCreditScore, StatusesType accountStatus) {
        try {
            setAccountID();
            this.AccountStatus = accountStatus;
            this.AccountBalance = accountBalance;
            this.ContractCollection = new ArrayList<>();
            this.AccountCreditScore = accountCreditScore;
        } catch (IllegalArgumentException aa) {
            System.out.println("Exception has been thrown:" + aa.toString());
            throw aa;
        }
    }

    public int getAccountID() {
        return AccountID;
    }

    private void setAccountID() {
        AccountID = Sequence.getBranchSeq();
    }

    public StatusesType getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(StatusesType accountStatus) {
        if (accountStatus.equals(StatusesType.Unspecified)) {
            throw new IllegalArgumentException("AccountStatus");
        } else
            AccountStatus = accountStatus;
    }

    public List<Contract> getContractCollection() {
        return ContractCollection;
    }

    public void setContractCollection(List<Contract> contractCollection) {
        ContractCollection = contractCollection;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        if (accountBalance < 0) {
            throw new IllegalArgumentException("AccountBalance");
        } else
            AccountBalance = accountBalance;
    }

    public int getAccountCreditScore() {
        return AccountCreditScore;
    }

    public void setAccountCreditScore(int accountCreditScore) {
        if (accountCreditScore < 0) {
            throw new IllegalArgumentException("AccountCreditScore");
        } else
            AccountCreditScore = accountCreditScore;
    }

       /*
        public bool IsNull()
        {
            return AccountID == 0;
        }
    */
}
