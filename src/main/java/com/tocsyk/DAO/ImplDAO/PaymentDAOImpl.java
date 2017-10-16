package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("paymentDAO")
public class PaymentDAOImpl {
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
