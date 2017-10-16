package com.tocsyk.model;

import javax.persistence.*;

@Entity
@Table(name = "hContractType")
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;

    @Column(name="Contract_type")
    private String contractType;

    public ContractType() {
    }

    public ContractType(String contract_type) {
        this.contractType = contractType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    @Override
    public String toString() {
        return "ContractType{" +
                "ID=" + ID +
                ", contract_type='" + contractType + '\'' +
                '}';
    }
}
