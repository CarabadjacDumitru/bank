package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Bank;

import java.util.List;

public interface AbstractBankDAO {

    List<Bank> getAllBanks();
    Bank getBank(int ID);
    int registerBank(Bank bank);
}
