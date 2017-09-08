package com.tocsyk.models;

public class Credit extends  Contract {
    public  Credit(double paidAmount, double contractRate, double remainingAmount)
    {
        super(paidAmount, contractRate, remainingAmount);
        this.ContractType = ContractType.Credit;
        this.Rate = 0.3;
    }
}
