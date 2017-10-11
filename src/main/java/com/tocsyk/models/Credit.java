package com.tocsyk.models;

import com.tocsyk.models.enums.ContractType;

public class Credit extends  Contract {
    public  Credit(float paidAmount, float contractRate)
    {
        super(paidAmount, contractRate);
        this.contractType = ContractType.Credit;
        this.rate = 0.3f;
    }
}
