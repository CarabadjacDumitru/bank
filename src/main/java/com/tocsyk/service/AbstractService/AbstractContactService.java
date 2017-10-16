package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Contact;

public interface AbstractContactService {
    int registerContact(Contact contact);
    Contact loadContactDataByID(int contactID);
}
