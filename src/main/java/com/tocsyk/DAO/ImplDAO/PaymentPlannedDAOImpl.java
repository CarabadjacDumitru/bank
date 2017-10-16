package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.PaymentPlanned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("paymentPlannedDAO")
public class PaymentPlannedDAOImpl {
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
