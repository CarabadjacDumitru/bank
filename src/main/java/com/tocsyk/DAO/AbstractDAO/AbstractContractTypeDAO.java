package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.AccountStatus;

import java.util.List;

public interface AbstractContractTypeDAO {
    List<AccountStatus> findAllContractType();
    AccountStatus getContractTypeByName(String name);
    AccountStatus getContractTypeByID(int ID);
}
