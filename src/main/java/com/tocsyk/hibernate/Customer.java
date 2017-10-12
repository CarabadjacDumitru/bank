package com.tocsyk.hibernate;

import com.tocsyk.models.Contact;

import javax.persistence.*;

@Entity
@Table(name = "hCustomer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="CreditScore")
    private float creditScore;
    @Column(name="Balance")
    private float balance;
    @Column(name="Branch_Customer")
    private Branch motherBranch;
    @Column(name="Contact")
    private Contact contact;

    public Customer() {
    }

    public Customer(float creditScore, float balance, Branch motherBranch, Contact contact) {
        this.contact = contact;
        this.creditScore = creditScore;
        this.balance = balance;
        this.motherBranch = motherBranch;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @OneToOne
    @JoinTable(name = "hContact", joinColumns = {@JoinColumn(name = "customer_contact")})
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
    @JoinColumn(name = "branch_customer")
    @JoinTable(name = "hBranch", joinColumns = {@JoinColumn(name = "ID")})
    public Branch getMotherBranch() {
        return motherBranch;
    }

    public void setMotherBranch(Branch motherBranch) {
        this.motherBranch = motherBranch;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", contact=" + contact +
                ", creditScore=" + creditScore +
                ", balance=" + balance +
                ", motherBranch=" + motherBranch +
                '}';
    }
}
