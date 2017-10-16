package com.tocsyk.model.enums;

public enum PaymentType {
    Unspecified(0),
    Debited(1),
    Credited(2);

    private int paymentType;

    PaymentType(int paymentType) {
        this.paymentType = paymentType;

    }
}
