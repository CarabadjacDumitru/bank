package com.tocsyk.service.ImplService;

import com.tocsyk.model.Bank;
import com.tocsyk.model.Branch;
import com.tocsyk.model.Customer;
import com.tocsyk.service.AbstractService.AbstractBranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("branchService")
public class BranchServiceImpl implements AbstractBranchService {

    @Override
    public List<Branch> findAllBranchesByBank(Bank bank) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomersByBranch() {
        return null;
    }

    @Override
    public int registerBranch(Branch branch) {
        return 0;
    }

    @Override
    public Branch loadBranchDataByID(int branchID) {
        return null;
    }
}
