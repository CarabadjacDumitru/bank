package com.tocsyk.models;

public class Deposit extends Contract {
    public Deposit(double paidAmount, double contractRate, double remainingAmount) {
        super( paidAmount, contractRate, remainingAmount);
        this.ContractType = ContractType.Debit;
        this.Rate = -0.2;
    }
}
