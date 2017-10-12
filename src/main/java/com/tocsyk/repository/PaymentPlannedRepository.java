package com.tocsyk.repository;

import com.tocsyk.hibernate.PaymentPlanned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class PaymentPlannedRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<PaymentPlanned> findAllPaymentPlanned(){
        return this.hibernateTemplate.loadAll(PaymentPlanned.class);
    }

    public int registerBranch(PaymentPlanned paymentPlanned){
        PaymentPlanned mergePaymentPlanned = this.hibernateTemplate.merge(paymentPlanned);
        return mergePaymentPlanned.getID();
    }

    public PaymentPlanned loadPaymentPlannedData(int payment){
        return this.hibernateTemplate.load(PaymentPlanned.class, payment);
    }
}
