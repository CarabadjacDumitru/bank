package com.tocsyk.service.ImplService;

import com.tocsyk.model.AccountStatus;
import com.tocsyk.service.AbstractService.AbstractPaymentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("paymentType")
public class PaymentTypeServiceImpl implements AbstractPaymentTypeService {
    @Override
    public List<AccountStatus> findAllPaymentType() {
        return null;
    }

    @Override
    public AccountStatus getPaymentTypeByName(String name) {
        return null;
    }

    @Override
    public AccountStatus getPaymentTypeByID(int ID) {
        return null;
    }
}
