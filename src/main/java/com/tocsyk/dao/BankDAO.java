package com.tocsyk.dao;

import com.tocsyk.models.Bank;
import com.tocsyk.models.Branch;
import java.util.List;

public interface BankDAO {
    List<Branch> findAllBranches();
    void registerBank(Bank bank);
    Bank loadBankData(String bankName);
}
