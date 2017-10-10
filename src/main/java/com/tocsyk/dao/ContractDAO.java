package com.tocsyk.dao;

import com.tocsyk.models.Contract;
import java.util.List;

public interface ContractDAO {
    List<Contract> findAllContracts();
    void registerContract(Contract contract);
    Contract loadContractData(String contractName);
}
