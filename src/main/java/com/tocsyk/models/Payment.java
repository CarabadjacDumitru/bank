package com.tocsyk.models;

import com.tocsyk.enums.ContractType;
import com.tocsyk.enums.StatusesType;

import java.util.Date;

public class Payment {

    protected Contract PaymentContract;
    protected double PaymentAmount;
    protected Date PaymentDate;
    protected Account PaymentAccount;
    protected int PaymentID;

    public Payment(Date paymentDate, Account paymentAccount, double paymentAmount, Contract paymentContract) {

        this.PaymentContract = paymentContract;
        this.PaymentAmount = paymentAmount;
        this.PaymentDate = paymentDate;
        this.PaymentAccount = paymentAccount;
        this.PaymentID = PaymentID;

    }



    public Contract getPaymentContract() {
        return PaymentContract;
    }

    public void setPaymentContract(Contract paymentContract) {
        if (paymentContract.getContractType().equals(ContractType.Unspecified)) {
            throw new IllegalArgumentException("PaymentContract");
        } else
            PaymentContract = paymentContract;
    }

    public double getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {

        if (paymentAmount < 0) {
            throw new IllegalArgumentException("PaymentAmount");
        } else
            PaymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = new Date();
    }

    public Account getPaymentAccount() {
        return PaymentAccount;
    }

    public void setPaymentAccount(Account paymentAccount) {
        if (paymentAccount.getAccountStatus().equals(StatusesType.Unspecified)) {
            throw new IllegalArgumentException("AccountStatus");
        } else
            PaymentAccount = paymentAccount;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int paymentID) {
        PaymentID = Sequence.getPaymentSeq();
    }


        /*

        public bool IsNull()
        {
            return PaymentID == 0;
        }
        */
}
