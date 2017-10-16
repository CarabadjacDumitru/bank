package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Payment;

import java.util.List;

public interface AbstractPaymentDAO {
     List<Payment> findAllPaymentsByContract();
     int registerPayment(Payment payment);
     Payment loadPaymentByID(int  idPayment);
}
