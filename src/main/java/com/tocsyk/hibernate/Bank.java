package com.tocsyk.hibernate;


import com.tocsyk.models.Contact;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hBank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Balance")
    private float balance;
    @Column(name="Contact")
    private Contact contact;
    @Column(name="Branches")
    private List<Branch> listBranches;

    public Bank() {
    }

    public Bank(Contact contact, float balance) {
        this.contact = contact;
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @OneToOne
    @JoinTable(name="hContact",joinColumns = {@JoinColumn(name = "bank_contact") })
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

    @OneToMany(mappedBy = "ID", cascade = CascadeType.ALL)
    @JoinTable(name = "hBranch", joinColumns = { @JoinColumn(name = "bank_branch") })
    public List<Branch> getListBranches() {
        return listBranches;
    }

    public void setListBranches(List<Branch> listBranches) {
        this.listBranches = listBranches;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "ID=" + ID +
                ", balance=" + balance +
                ", contact=" + contact +
                ", listBranches=" + listBranches +
                '}';
    }
}
