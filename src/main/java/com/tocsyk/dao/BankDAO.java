package com.tocsyk.dao;

import com.tocsyk.models.Bank;
import java.util.List;

public interface BankDAO {
    List<Bank> findAllBanks();
    void registerBank(Bank bank);
    Bank loadBankData(String bankName);
}
