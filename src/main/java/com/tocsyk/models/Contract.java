package com.tocsyk.models;

import com.tocsyk.models.enums.ContractType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    protected Date GenerationDate;
    protected Date FinishingDate;
    protected com.tocsyk.models.enums.ContractType ContractType;
    protected double Rate;
    protected double RemainingAmount;
    protected double PaidAmount;
    protected int ContractScore;
    protected int ContractID;
    protected List<Payment> PaymentCollection;
    protected List<Date> PaymentDateMonthly;


    protected Contract(double paidAmount, double contractRate, double remainingAmount) {
        try {
            setContractID();
            this.GenerationDate = new Date();
            this.FinishingDate = new Date();
            this.RemainingAmount = remainingAmount;
            this.PaidAmount = paidAmount;
            this.PaymentCollection = new ArrayList<Payment>();
            this.PaymentDateMonthly = new ArrayList<Date>();
            this.ContractScore = 0;
            generateGenDates();
        } catch (IllegalArgumentException aa) {
            System.out.println("Exception has been thrown:" + aa.toString());
            throw aa;
        }

    }

    private void generateGenDates(){
        for (Date dt = GenerationDate; dt.after(FinishingDate); dt.setMonth(dt.getMonth() + 1)) {
            PaymentDateMonthly.add(dt);
        }
    }
    public Date getGenerationDate() {
        return GenerationDate;
    }

    public void setGenerationDate(Date generationDate) {
        if (generationDate.compareTo(new Date()) > 0) {
            throw new IllegalArgumentException("GenerationDate");
        } else
            GenerationDate = generationDate;
    }

    public Date getFinishingDate() {
        return FinishingDate;
    }

    public void setFinishingDate(Date finishingDate) {
        if (finishingDate.compareTo(new Date()) < 0) {
            throw new IllegalArgumentException("FinishingDate");
        } else
            FinishingDate = finishingDate;
    }

    public ContractType getContractType() {
        return ContractType;
    }

    public void setContractType(ContractType contractType) {
        if (contractType.equals(ContractType.Unspecified)) {
            throw new IllegalArgumentException("ContractType");
        } else
            ContractType = contractType;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        if (rate < 0 || rate > 100) {
            throw new IllegalArgumentException("Rate");
        } else
            Rate = rate;
    }

    public double getRemainingAmount() {
        return RemainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        if (remainingAmount < 0) {
            throw new IllegalArgumentException("RemainingAmount");
        } else
            RemainingAmount = remainingAmount;
    }

    public double getPaidAmount() {
        return PaidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        if (paidAmount < 0) {
            throw new IllegalArgumentException("PaidAmount");
        } else
            PaidAmount = paidAmount;
    }

    public int getContractScore() {
        return ContractScore;
    }

    public void setContractScore(int contractScore) {
        if (contractScore < 0) {
            throw new IllegalArgumentException("ContractScore");
        } else
            ContractScore = contractScore;
    }

    public int getContractID() {
        return ContractID;
    }

    private void setContractID() {
        ContractID = Sequence.getContractSeq();
    }

    public List<Payment> getPaymentCollection() {
        return PaymentCollection;
    }

    public void setPaymentCollection(List<Payment> paymentCollection) {
        PaymentCollection = paymentCollection;
    }

    public List<Date> getPaymentDateMonthly() {
        return PaymentDateMonthly;
    }

    public void setPaymentDateMonthly(List<Date> paymentDateMonthly) {
        PaymentDateMonthly = paymentDateMonthly;
    }

 /*
        public bool IsNull()
        {
            return ContractID == 0;
        }*/

}
