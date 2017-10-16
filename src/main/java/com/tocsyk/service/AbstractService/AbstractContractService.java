package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Contract;
import com.tocsyk.model.Customer;

import java.util.List;

public interface AbstractContractService {
    List<Contract> findAllContracts();
    List<Contract> findAllContractsByCustomer(Customer customer);
    int registerContract(Contract contract);
    Contract loadContractData(int contractID);
}
