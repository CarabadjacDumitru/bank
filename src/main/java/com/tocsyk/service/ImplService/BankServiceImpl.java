package com.tocsyk.service.ImplService;

import com.tocsyk.model.Bank;
import com.tocsyk.service.AbstractService.AbstractBankService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bankService")
public class BankServiceImpl implements AbstractBankService {
    @Override
    public List<Bank> getAllBanks() {
        return null;
    }

    @Override
    public Bank getBank(int ID) {
        return null;
    }

    @Override
    public int registerBank(Bank bank) {
        return 0;
    }
}
