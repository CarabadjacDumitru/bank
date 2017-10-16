package com.tocsyk.service.ImplService;

import com.tocsyk.model.Payment;
import com.tocsyk.service.AbstractService.AbstractPaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("paymentService")
public class PaymentServiceImpl implements AbstractPaymentService {

    @Override
    public List<Payment> findAllPaymentsByContract() {
        return null;
    }

    @Override
    public int registerPayment(Payment payment) {
        return 0;
    }

    @Override
    public Payment loadPaymentByID(int idPayment) {
        return null;
    }
}
