package com.tocsyk.dao;

import com.tocsyk.models.Payment;
import java.util.List;

public interface PaymentDAO {
    List<Payment> findAllPayment();
    void registerPayment(Payment payment);
    void rejectPayment(Payment payment);
    void modifyPayment(Payment payment);
    Payment loadPaymentData(String paymentName);
}
