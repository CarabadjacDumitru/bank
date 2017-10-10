package com.tocsyk.dao;

import com.tocsyk.models.Branch;
import com.tocsyk.models.Customer;
import java.util.List;

public interface BranchDAO {
    List<Customer> findAllCustomers();
    void registerBranch(Branch branch);
    Branch loadBranchData(String branchName);
    float getBranchBalance();
}
