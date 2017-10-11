package com.tocsyk.models;

import com.tocsyk.models.enums.ContractType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    protected int ID;
    protected Date dateGeneration;
    protected Date dateFinishing;
    protected ContractType contractType;
    protected float rate;
    protected float amountRemain;
    protected float amountPaid;
    protected int contractScore;
    protected List<Payment> paymentList;
    protected List<Date> paymentPlanned;


    protected Contract(float amountToPay, float contractRate) {
            this.dateGeneration = new Date();
            this.dateFinishing = new Date();
            this.amountPaid= 0;
            this.amountRemain = amountToPay;
            this.paymentList= new ArrayList<Payment>();
            this.paymentPlanned= new ArrayList<Date>();
            this.rate = 1;
            this.contractScore = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDateGeneration() {
        return dateGeneration;
    }

    public void setDateGeneration(Date dateGeneration) {
        this.dateGeneration = dateGeneration;
    }

    public Date getDateFinishing() {
        return dateFinishing;
    }

    public void setDateFinishing(Date dateFinishing) {
        this.dateFinishing = dateFinishing;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getAmountRemain() {
        return amountRemain;
    }

    public void setAmountRemain(float amountRemain) {
        this.amountRemain = amountRemain;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public int getScore() {
        return contractScore;
    }

    public void setScore(int contractScore) {
        this.contractScore = contractScore;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Date> getPaymentPlanned() {
        return paymentPlanned;
    }

    public void setPaymentPlanned(List<Date> paymentPlanned) {
        this.paymentPlanned = paymentPlanned;
    }
}
