package com.tocsyk.service.AbstractService;

import com.tocsyk.model.AccountStatus;

import java.util.List;

public interface AbstractPaymentTypeService {
    List<AccountStatus> findAllPaymentType();
    AccountStatus getPaymentTypeByName(String name);
    AccountStatus getPaymentTypeByID(int ID);
}
