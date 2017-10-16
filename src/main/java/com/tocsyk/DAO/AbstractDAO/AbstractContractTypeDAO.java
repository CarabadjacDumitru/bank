package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Contact;

import java.util.List;

public interface AbstractContractTypeDAO {
    List<Contact.AccountStatus> findAllContractType();
    Contact.AccountStatus getContractTypeByName(String name);
    Contact.AccountStatus getContractTypeByID(int ID);
}
