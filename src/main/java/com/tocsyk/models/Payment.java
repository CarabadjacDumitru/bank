package com.tocsyk.models;

import com.tocsyk.models.enums.PaymentType;

import java.util.Date;

public class Payment {

    protected int ID;
    protected Contract contract;
    protected float amount;
    protected Date date;
    protected PaymentType paymentType;

    public Payment(Date date, float amount, Contract contract, PaymentType paymentType) {
        this.contract = contract;
        this.amount = amount;
        this.date = date;
        this.paymentType = paymentType;
    }

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
