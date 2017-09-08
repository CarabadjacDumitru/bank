package com.tocsyk.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    protected int CustomerID;
    protected Address CustomerAddress;
    protected int CustomerCreditScore;
    protected List<Account> AccountCollection;

    public Customer(int customerCreditScore, Address customerAddress) {
        try {
            setCustomerID();
            this.CustomerCreditScore = customerCreditScore;
            this.CustomerAddress = customerAddress;
            this.AccountCollection = new ArrayList<Account>();
            this.CustomerID = CustomerID;
        } catch (IllegalArgumentException aa) {
            System.out.println("Exception has been thrown:" + aa.toString());
            throw aa;
        }
    }

    public int getCustomerID() {
        return CustomerID;
    }

    private void setCustomerID() {
        CustomerID = Sequence.getCustomerSeq();
    }

    public Address getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        CustomerAddress = customerAddress;
    }

    public int getCustomerCreditScore() {
        return CustomerCreditScore;
    }

    public void setCustomerCreditScore(int customerCreditScore) {
        if (customerCreditScore < 0) {
            throw new IllegalArgumentException("CustomerCreditScore");
        } else
            CustomerCreditScore = customerCreditScore;
    }

    public List<Account> getAccountCollection() {
        return AccountCollection;
    }

    public void setAccountCollection(List<Account> accountCollection) {
        AccountCollection = accountCollection;
    }



        /*
        public bool IsNull()
        {
            return this.CustomerID == 0;
        }*/
}
