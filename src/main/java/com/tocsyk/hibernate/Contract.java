package com.tocsyk.hibernate;

import com.tocsyk.models.Payment;
import com.tocsyk.models.enums.ContractType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hContract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="DateGeneration")
    private Date DateGeneration;
    @Column(name="DateFinishing")
    private Date DateFinishing;
    @Column(name="Rate")
    private float rate;
    @Column(name="Score")
    private float score;
    @Column(name="AmountRemain")
    private float amountRemain;
    @Column(name="AmountPaid")
    private float amountPaid;

    @Column(name="ContractType")
    private ContractType contractType;
    @Column(name="Account_Contract")
    private Account motherAccount;

    @Column(name="Payments")
    private List<Payment> listPayments;

    public Contract() {
    }

    public Contract(Date dateGeneration, Date dateFinishing, float rate, float score, float amountRemain, float amountPaid, ContractType contractType, Account motherAccount) {
        this.DateGeneration = dateGeneration;
        this.DateFinishing = dateFinishing;
        this.rate = rate;
        this.score = score;
        this.amountRemain = amountRemain;
        this.amountPaid = amountPaid;
        this.contractType = contractType;
        this.motherAccount = motherAccount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDateGeneration() {
        return DateGeneration;
    }

    public void setDateGeneration(Date dateGeneration) {
        DateGeneration = dateGeneration;
    }

    public Date getDateFinishing() {
        return DateFinishing;
    }

    public void setDateFinishing(Date dateFinishing) {
        DateFinishing = dateFinishing;
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

    @OneToOne
    @JoinColumn(name = "contract_type")
    @JoinTable(name = "hcontract_type", joinColumns = {@JoinColumn(name = "ID")})
    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Account getMotherAccount() {
        return motherAccount;
    }

    public void setMotherAccount(Account motherAccount) {
        this.motherAccount = motherAccount;
    }

    public List<Payment> getListPayments() {
        return listPayments;
    }

    public void setListPayments(List<Payment> listPayments) {
        this.listPayments = listPayments;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "ID=" + ID +
                ", DateGeneration=" + DateGeneration +
                ", DateFinishing=" + DateFinishing +
                ", rate=" + rate +
                ", score=" + score +
                ", amountRemain=" + amountRemain +
                ", amountPaid=" + amountPaid +
                ", contractType=" + contractType +
                ", motherAccount=" + motherAccount +
                ", listPayments=" + listPayments +
                '}';
    }
}
