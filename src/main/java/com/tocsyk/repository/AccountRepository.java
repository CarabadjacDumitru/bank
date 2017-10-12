package com.tocsyk.repository;

import com.tocsyk.hibernate.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class AccountRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Bank> getAllBanks() {
        return this.hibernateTemplate.loadAll(Bank.class);
    }

    public Bank getBank(int ID) {
        return this.hibernateTemplate.load(Bank.class, ID);
    }

    public int registerBank(Bank bank) {
        Bank mergeBank = this.hibernateTemplate.merge(bank);
        return mergeBank.getID();
    }

}
