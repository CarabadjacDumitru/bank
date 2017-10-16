package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Bank;

import java.util.List;

public interface AbstractBankService {
    List<Bank> getAllBanks();
    Bank getBank(int ID);
    int registerBank(Bank bank);
}

