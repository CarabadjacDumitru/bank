package com.tocsyk.hibernate;

import com.tocsyk.models.enums.AccountStatusType;

import javax.persistence.*;

@Entity
@Table(name = "hAccount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="CreditScore")
    private float creditScore;
    @Column(name="Balance")
    private float balance;
    @Column(name="customer_account")
    private Account motherAccount;
    @Column(name="account_status")
    private AccountStatusType accountStatusType;

    public Account() {
    }

    public Account(float creditScore, float balance, Account customerAccount, AccountStatusType accountStatusType) {
        this.creditScore = creditScore;
        this.balance = balance;
        this.motherAccount = customerAccount;
        this.accountStatusType = accountStatusType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(float creditScore) {
        this.creditScore = creditScore;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @ManyToOne
    @JoinColumn(name = "customer_account")
    @JoinTable(name = "hCustomer", joinColumns = {@JoinColumn(name = "ID")})
    public Account getCustomerAccount() {
        return motherAccount;
    }

    public void setCustomerAccount(Account customerAccount) {
        this.motherAccount = customerAccount;
    }

    @OneToOne
    @JoinColumn(name = "account_status")
    @JoinTable(name = "hAccount_status", joinColumns = {@JoinColumn(name = "id")})
    public AccountStatusType getAccountStatusType() {
        return accountStatusType;
    }

    public void setAccountStatusType(AccountStatusType accountStatusType) {
        this.accountStatusType = accountStatusType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", creditScore=" + creditScore +
                ", balance=" + balance +
                ", customerAccount=" + motherAccount +
                ", accountStatusType=" + accountStatusType +
                '}';
    }
}
