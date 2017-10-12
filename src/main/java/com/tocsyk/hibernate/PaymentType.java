package com.tocsyk.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "hPaymentType")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int ID;
    @Column(name="Payment_type")
    private String payment_type;

    public PaymentType() {
    }

    public PaymentType(String payment_type) {
        this.payment_type = payment_type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "ID=" + ID +
                ", payment_type='" + payment_type + '\'' +
                '}';
    }
}
