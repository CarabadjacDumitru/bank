package com.tocsyk.models;

import com.tocsyk.models.enums.ContractType;

public class Grant extends Contract {
    public Grant(float paidAmount, float contractRate) {
        super(paidAmount, contractRate);
        this.contractType = ContractType.Grant;
        this.rate = -0.1f;
    }
}
