package com.tocsyk.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "hContractType")
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Contract_type")
    private String contract_type;

    public ContractType() {
    }

    public ContractType(String contract_type) {
        this.contract_type = contract_type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    @Override
    public String toString() {
        return "ContractType{" +
                "ID=" + ID +
                ", contract_type='" + contract_type + '\'' +
                '}';
    }
}
