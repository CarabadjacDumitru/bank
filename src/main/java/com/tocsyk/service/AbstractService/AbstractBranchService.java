package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Bank;
import com.tocsyk.model.Branch;
import com.tocsyk.model.Customer;

import java.util.List;

public interface AbstractBranchService {
    List<Branch> findAllBranchesByBank(Bank bank);
    List<Customer> findAllCustomersByBranch();
    int registerBranch(Branch branch);
    Branch loadBranchDataByID(int branchID);
}

