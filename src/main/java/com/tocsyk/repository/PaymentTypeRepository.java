package com.tocsyk.repository;

import com.tocsyk.hibernate.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class PaymentTypeRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<PaymentType> findAllPaymentType(){
        return this.hibernateTemplate.loadAll(PaymentType.class);
    }

    public int registerBranch(PaymentType paymentType){
        PaymentType mergePaymentType = this.hibernateTemplate.merge(paymentType);
        return mergePaymentType.getID();
    }

    public PaymentType loadPaymentTypeData(int paymentType){
        return this.hibernateTemplate.load(PaymentType.class, paymentType);
    }
}
