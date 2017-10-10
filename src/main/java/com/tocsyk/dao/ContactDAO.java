package com.tocsyk.dao;

import com.tocsyk.models.Contact;

public interface ContactDAO {
    void registerContact(Contact contact);
    Contact loadContactData(String contactName);
}
