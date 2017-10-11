package com.tocsyk.models;

import com.tocsyk.models.enums.ContractType;

public class Deposit extends Contract {
    public Deposit(float  paidAmount, float contractRate) {
        super(paidAmount, contractRate);
        this.contractType = ContractType.Debit;
        this.rate = -0.2f;
    }
}
