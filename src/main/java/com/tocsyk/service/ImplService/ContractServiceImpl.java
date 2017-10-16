package com.tocsyk.service.ImplService;

import com.tocsyk.model.Contract;
import com.tocsyk.model.Customer;
import com.tocsyk.service.AbstractService.AbstractContractService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("contractService")
public class ContractServiceImpl implements AbstractContractService {
    @Override
    public List<Contract> findAllContracts() {
        return null;
    }

    @Override
    public List<Contract> findAllContractsByCustomer(Customer customer) {
        return null;
    }

    @Override
    public int registerContract(Contract contract) {
        return 0;
    }

    @Override
    public Contract loadContractData(int contractID) {
        return null;
    }
}
