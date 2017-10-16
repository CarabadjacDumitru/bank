package com.tocsyk.service.ImplService;

import com.tocsyk.DAO.ImplDAO.AccountDAOImpl;
import com.tocsyk.model.Bank;
import com.tocsyk.service.AbstractService.AbstractAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AbstractAccountService{

    @Autowired
    private AccountDAOImpl accountDAO;

    public List<Bank> getAllBanks() {
        return null;
    }

    public Bank getBank(int ID) {
        return null;
    }

    public int registerBank(Bank bank) {
        return 0;
    }
}
