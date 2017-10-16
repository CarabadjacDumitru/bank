package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Payment;

import java.util.List;

public interface AbstractPaymentService {
    List<Payment> findAllPaymentsByContract();
    int registerPayment(Payment payment);
    Payment loadPaymentByID(int  idPayment);
}
