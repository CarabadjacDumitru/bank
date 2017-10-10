package com.tocsyk.dao;

import com.tocsyk.models.Contract;
import com.tocsyk.models.Payment;
import java.util.List;

public interface ContractDAO {
    List<Payment> findAllPayments();
    void registerContract(Contract contract);
    float getContractDebt();
    Contract loadContractData(String contractName);
    void modifyContract(Contract contract);
}
