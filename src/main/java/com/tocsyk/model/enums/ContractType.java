package com.tocsyk.model.enums;

public enum ContractType {
    Unspecified(0),
    Credit(1),
    Debit(2),
    Leasing(3),
    Grant(4);

    private int contractType;

    ContractType(int contractType) {
        this.contractType = contractType;

    }
}
