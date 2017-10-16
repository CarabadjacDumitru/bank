package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Contact;

public interface AbstractContactDAO {
     int registerContact(Contact contact);
     Contact loadContactDataByID(int contactID);
}
