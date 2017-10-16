package com.tocsyk.model;

import javax.persistence.*;


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
    private int motherBankID;
    @Column(name="Contact")
    private int contactID;
    /*@Column(name="Customers")
    private List<Customer> listCustomers;*/

    public Branch() {
    }

    public Branch(float balance, int motherBankID, int contactID) {
        this.contactID = contactID;
        this.balance = balance;
        this.motherBankID = motherBankID;
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

    public int getMotherBank() {
        return motherBankID;
    }

    public void setMotherBank(int motherBank) {
        this.motherBankID = motherBank;
    }

    /*public List<Customer> getListCustomers() {
        return listCustomers;
    }

    public void setListCustomers(List<Customer> listCustomers) {
        this.listCustomers = listCustomers;
    }*/

    @Override
    public String toString() {
        return "Branch{" +
                "ID=" + ID +
                ", balance=" + balance +
                ", motherBank=" + motherBankID +
                ", contact=" + contactID +
                /*", listCustomers=" + listCustomers +*/
                '}';
    }
}
