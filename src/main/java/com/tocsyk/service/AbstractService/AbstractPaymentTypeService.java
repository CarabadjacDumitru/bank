package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Contact;

import java.util.List;

public interface AbstractPaymentTypeService {
    List<Contact.AccountStatus> findAllPaymentType();
    Contact.AccountStatus getPaymentTypeByName(String name);
    Contact.AccountStatus getPaymentTypeByID(int ID);
}
