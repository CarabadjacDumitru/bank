package com.tocsyk.dao;

import com.tocsyk.models.Branch;

import java.util.List;

public interface BranchDAO {
    List<Branch> findAllBranches();
    void registerBranch(Branch branch);
    Branch loadBranchData(String branchName);
}
