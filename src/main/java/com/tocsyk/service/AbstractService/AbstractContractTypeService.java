package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Contact;

import java.util.List;

public interface AbstractContractTypeService {
    List<Contact.AccountStatus> findAllContractType();
    Contact.AccountStatus getContractTypeByName(String name);
    Contact.AccountStatus getContractTypeByID(int ID);
}
