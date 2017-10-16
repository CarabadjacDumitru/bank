package com.tocsyk.model;


import javax.persistence.*;

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
    private int contactID;
    /*@Column(name="Branches")
    private List<Branch> listBranches;*/

    public Bank() {
    }

    public Bank(int contact, float balance) {
        this.contactID = contact;
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getContact() {
        return contactID;
    }

    public void setContact(int contact) {
        this.contactID = contact;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    /*public List<Branch> getListBranches() {
        return listBranches;
    }

    public void setListBranches(List<Branch> listBranches) {
        this.listBranches = listBranches;
    }*/

    @Override
    public String toString() {
        return "Bank{" +
                "ID=" + ID +
                ", balance=" + balance +
                ", contact=" + contactID +
                /*", listBranches=" + listBranches +*/
                '}';
    }
}
