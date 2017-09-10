package com.tocsyk.messages;

public class PaymentMessages {
    protected String PaymentContract;
    protected String PaymentAmount;
    protected String PaymentDate;
    protected String PaymentAccount;

    public String getPaymentContract() {
        return PaymentContract;
    }

    public void setPaymentContract(String paymentContract) {
        PaymentContract = paymentContract;
    }
}
