package com.tocsyk.service.ImplService;

import com.tocsyk.model.Contact;
import com.tocsyk.service.AbstractService.AbstractPaymentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("paymentType")
public class PaymentTypeServiceImpl implements AbstractPaymentTypeService {
    @Override
    public List<Contact.AccountStatus> findAllPaymentType() {
        return null;
    }

    @Override
    public Contact.AccountStatus getPaymentTypeByName(String name) {
        return null;
    }

    @Override
    public Contact.AccountStatus getPaymentTypeByID(int ID) {
        return null;
    }
}
