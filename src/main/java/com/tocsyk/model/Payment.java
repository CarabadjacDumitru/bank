package com.tocsyk.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "hPayment")
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
    private int motherContractID;
    @Column(name="PaymentType")
    private int paymentTypeID;

    public Payment() {
    }

    public Payment(float amount, Date date, int motherContractID, int paymentTypeID) {
        this.amount = amount;
        this.date = date;
        this.motherContractID = motherContractID;
        this.paymentTypeID = paymentTypeID;
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

    public int getMotherContract() {
        return motherContractID;
    }

    public void setMotherContract(int motherContract) {
        this.motherContractID = motherContract;
    }

    public int getPaymentType() {
        return paymentTypeID;
    }

    public void setPaymentType(int paymentType) {
        this.paymentTypeID = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + ID +
                ", amount=" + amount +
                ", date=" + date +
                ", motherContract=" + motherContractID +
                ", paymentType=" + paymentTypeID +
                '}';
    }
}
