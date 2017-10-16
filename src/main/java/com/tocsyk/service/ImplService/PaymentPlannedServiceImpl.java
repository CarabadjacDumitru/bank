package com.tocsyk.service.ImplService;

import com.tocsyk.model.PaymentPlanned;
import com.tocsyk.service.AbstractService.AbstractPaymentPlannedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("paymentPlannedService")
public class PaymentPlannedServiceImpl implements AbstractPaymentPlannedService{

    @Override
    public List<PaymentPlanned> findAllPaymentPlanned() {
        return null;
    }

    @Override
    public int registerPaymentPlanned(PaymentPlanned paymentPlanned) {
        return 0;
    }

    @Override
    public PaymentPlanned loadPaymentPlannedData(int payment) {
        return null;
    }
}
