package com.tocsyk.dao;

import com.tocsyk.models.Payment;

public interface PaymentDAO {
    void registerPayment(Payment payment);
    void rejectPayment(Payment payment);
    void modifyPayment(Payment payment);
    Payment loadPaymentData(String paymentName);
}
