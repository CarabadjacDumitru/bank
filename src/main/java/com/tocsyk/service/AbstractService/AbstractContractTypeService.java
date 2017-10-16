package com.tocsyk.service.AbstractService;

import com.tocsyk.model.AccountStatus;

import java.util.List;

public interface AbstractContractTypeService {
    List<AccountStatus> findAllContractType();
    AccountStatus getContractTypeByName(String name);
    AccountStatus getContractTypeByID(int ID);
}
