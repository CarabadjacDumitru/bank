package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Contact;

import java.util.List;

public interface AbstractAccountStatusDAO {
    List<Contact.AccountStatus> findAllAccountStatus();
    Contact.AccountStatus getAccountStatusByName(String name);
    Contact.AccountStatus getAccountStatusByID(int ID);
}
