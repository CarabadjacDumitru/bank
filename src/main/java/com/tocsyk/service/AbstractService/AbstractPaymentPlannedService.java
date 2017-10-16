package com.tocsyk.service.AbstractService;

import com.tocsyk.model.PaymentPlanned;

import java.util.List;

public interface AbstractPaymentPlannedService {
    List<PaymentPlanned> findAllPaymentPlanned();
    int registerPaymentPlanned(PaymentPlanned paymentPlanned);
    PaymentPlanned loadPaymentPlannedData(int payment);
}

