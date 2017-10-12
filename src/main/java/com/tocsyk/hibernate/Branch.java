package com.tocsyk.hibernate;

import com.tocsyk.models.Contact;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "hBranch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Balance")
    private float balance;
    @Column(name="MotherBank")
    private Bank motherBank;
    @Column(name="Contact")
    private Contact contact;
    @Column(name="Customers")
    private List<Customer> listCustomers;

    public Branch() {
    }

    public Branch(float balance, Bank motherBank, Contact contact) {
        this.contact = contact;
        this.balance = balance;
        this.motherBank = motherBank;
    }

    @OneToMany(mappedBy = "ID", cascade = CascadeType.ALL)
    @JoinTable(name = "hCustomer", joinColumns = {@JoinColumn(name = "branch_customer")})
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @OneToOne
    @JoinTable(name = "hContact", joinColumns = {@JoinColumn(name = "branch_contact")})
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @ManyToOne
    @JoinColumn(name = "bank_branch")
    @JoinTable(name = "hBank", joinColumns = {@JoinColumn(name = "ID")})
    public Bank getMotherBank() {
        return motherBank;
    }

    public void setMotherBank(Bank motherBank) {
        this.motherBank = motherBank;
    }

    public List<Customer> getListCustomers() {
        return listCustomers;
    }

    public void setListCustomers(List<Customer> listCustomers) {
        this.listCustomers = listCustomers;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "ID=" + ID +
                ", balance=" + balance +
                ", motherBank=" + motherBank +
                ", contact=" + contact +
                ", listCustomers=" + listCustomers +
                '}';
    }
}
