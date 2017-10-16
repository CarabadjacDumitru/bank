package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Contact;

import java.util.List;

public interface AbstractAccountStatusService {
    List<Contact.AccountStatus> findAllAccountStatus();
    Contact.AccountStatus getAccountStatusByName(String name);
    Contact.AccountStatus getAccountStatusByID(int ID);
}
