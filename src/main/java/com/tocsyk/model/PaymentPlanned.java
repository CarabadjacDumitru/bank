package com.tocsyk.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hPaymentPlanned")
public class PaymentPlanned {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="PlannedDate")
    private Date plannedDate;
    @Column(name="IsPaid")
    private boolean isPaid;
    @Column(name="PaidDate")
    private Date paidDate;
    @Column(name="Contract_Payment")
    private int motherContractID;

    public PaymentPlanned() {
    }

    public PaymentPlanned(Date plannedDate, boolean isPaid, Date paidDate, int motherContract) {
        this.plannedDate = plannedDate;
        this.isPaid = isPaid;
        this.paidDate = paidDate;
        this.motherContractID = motherContract;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public int getMotherContract() {
        return motherContractID;
    }

    public void setMotherContract(int motherContract) {
        this.motherContractID = motherContract;
    }

    @Override
    public String toString() {
        return "PaymentPlanned{" +
                "ID=" + ID +
                ", plannedDate=" + plannedDate +
                ", isPaid=" + isPaid +
                ", paidDate=" + paidDate +
                ", motherContract=" + motherContractID +
                '}';
    }
}
