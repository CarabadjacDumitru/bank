package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Contact;

import java.util.List;

public interface AbstractPaymentTypeDAO {
    List<Contact.AccountStatus> findAllPaymentType();
    Contact.AccountStatus getPaymentTypeByName(String name);
    Contact.AccountStatus getPaymentTypeByID(int ID);
}
