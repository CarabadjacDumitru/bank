package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.AccountStatus;

import java.util.List;

public interface AbstractPaymentTypeDAO {
    List<AccountStatus> findAllPaymentType();
    AccountStatus getPaymentTypeByName(String name);
    AccountStatus getPaymentTypeByID(int ID);
}
