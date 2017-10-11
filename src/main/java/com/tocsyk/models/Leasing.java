package com.tocsyk.models;

import com.tocsyk.models.enums.ContractType;

public class Leasing extends Contract {

    public Leasing(float paidAmount, float contractRate) {
        super(paidAmount, contractRate);
        this.contractType = ContractType.Leasing;
        this.rate = 0.2f;
    }
}
