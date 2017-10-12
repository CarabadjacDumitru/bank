package com.tocsyk.hibernate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Amount")
    private float amount;
    @Column(name="Date")
    private Date date;
    @Column(name="Contract_payment")
    private Contract motherContract;
    @Column(name="PaymentType")
    private PaymentType paymentType;

    public Payment() {
    }

    public Payment(float amount, Date date, Contract motherContract, PaymentType paymentType) {
        this.amount = amount;
        this.date = date;
        this.motherContract = motherContract;
        this.paymentType = paymentType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getAmount() {
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

    public Contract getMotherContract() {
        return motherContract;
    }

    public void setMotherContract(Contract motherContract) {
        this.motherContract = motherContract;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + ID +
                ", amount=" + amount +
                ", date=" + date +
                ", motherContract=" + motherContract +
                ", paymentType=" + paymentType +
                '}';
    }
}
