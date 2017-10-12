package com.tocsyk.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "hAccountStatus")
public class AccountStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Account_status")
    private String accountStatus;

    public AccountStatus() {
    }

    public AccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "AccountStatus{" +
                "ID=" + ID +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
