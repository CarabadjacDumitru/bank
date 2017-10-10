package com.tocsyk.dao;

import com.tocsyk.models.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAllContacts();
    void registerContact(Contact contact);
    Contact loadContactData(String contactName);

}
