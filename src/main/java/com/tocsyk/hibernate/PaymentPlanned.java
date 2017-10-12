package com.tocsyk.hibernate;

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
    private Contract motherContract;

    public PaymentPlanned() {
    }

    public PaymentPlanned(Date plannedDate, boolean isPaid, Date paidDate, Contract motherContract) {
        this.plannedDate = plannedDate;
        this.isPaid = isPaid;
        this.paidDate = paidDate;
        this.motherContract = motherContract;
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

    public Contract getMotherContract() {
        return motherContract;
    }

    public void setMotherContract(Contract motherContract) {
        this.motherContract = motherContract;
    }

    @Override
    public String toString() {
        return "PaymentPlanned{" +
                "ID=" + ID +
                ", plannedDate=" + plannedDate +
                ", isPaid=" + isPaid +
                ", paidDate=" + paidDate +
                ", motherContract=" + motherContract +
                '}';
    }
}
