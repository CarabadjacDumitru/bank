package com.tocsyk.repository;

import com.tocsyk.hibernate.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class PaymentRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Payment> findAllPayment(){
        return this.hibernateTemplate.loadAll(Payment.class);
    }

    public int registerBranch(Payment payment){
        Payment mergePayment = this.hibernateTemplate.merge(payment);
        return mergePayment.getID();
    }

    public Payment loadPaymentData(int payment){
        return this.hibernateTemplate.load(Payment.class, payment);
    }
}
