package com.tocsyk.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hContract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="DateGeneration")
    private Date dateGeneration;
    @Column(name="DateFinishing")
    private Date dateFinishing;
    @Column(name="Rate")
    private float rate;
    @Column(name="Score")
    private float score;
    @Column(name="AmountRemain")
    private float amountRemain;
    @Column(name="AmountPaid")
    private float amountPaid;
    @Column(name="ContractTypeID")
    private int contractTypeID;
    @Column(name="Account_Contract")
    private int motherAccountID;
    /*@Column(name="Payments")
    private List<Payment> listPayments;*/

    public Contract() {
    }

    public Contract(Date dateGeneration, Date dateFinishing, float rate, float score, float amountRemain, float amountPaid, int contractType, int motherAccount) {
        this.dateGeneration = dateGeneration;
        this.dateFinishing = dateFinishing;
        this.rate = rate;
        this.score = score;
        this.amountRemain = amountRemain;
        this.amountPaid = amountPaid;
        this.contractTypeID = contractType;
        this.motherAccountID = motherAccount;
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
        dateGeneration = dateGeneration;
    }

    public Date getDateFinishing() {
        return dateFinishing;
    }

    public void setDateFinishing(Date dateFinishing) {
        dateFinishing = dateFinishing;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    public int getContractTypeID() {
        return contractTypeID;
    }

    public void setContractTypeID(int contractType) {
        this.contractTypeID = contractType;
    }

    public int getMotherAccountID() {
        return motherAccountID;
    }

    public void setMotherAccountID(int motherAccount) {
        this.motherAccountID = motherAccount;
    }

    /*public List<Payment> getListPayments() {
        return listPayments;
    }

    public void setListPayments(List<Payment> listPayments) {
        this.listPayments = listPayments;
    }*/

    @Override
    public String toString() {
        return "Contract{" +
                "ID=" + ID +
                ", DateGeneration=" + dateGeneration +
                ", DateFinishing=" + dateFinishing +
                ", rate=" + rate +
                ", score=" + score +
                ", amountRemain=" + amountRemain +
                ", amountPaid=" + amountPaid +
                ", contractType=" + contractTypeID +
                ", motherAccount=" + motherAccountID +
                /*", listPayments=" + listPayments +*/
                '}';
    }
}
