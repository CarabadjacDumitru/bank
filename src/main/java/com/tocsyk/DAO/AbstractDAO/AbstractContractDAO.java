package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Contract;
import com.tocsyk.model.Customer;

import java.util.List;

public interface AbstractContractDAO {
    List<Contract> findAllContracts();
    List<Contract> findAllContractsByCustomer(Customer customer);
    int registerContract(Contract contract);
    Contract loadContractData(int contractID);
}
