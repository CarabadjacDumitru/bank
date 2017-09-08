package com.tocsyk.models;

public class Grant extends Contract{
    public Grant(double paidAmount, double contractRate, double remainingAmount)
    {
        super(paidAmount, contractRate, remainingAmount);
        this.ContractType = ContractType.Grant;
        this.Rate = -0.1;
    }
}
