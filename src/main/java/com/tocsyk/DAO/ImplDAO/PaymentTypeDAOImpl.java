package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("paymentTypeDAO")
public class PaymentTypeDAOImpl {
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
