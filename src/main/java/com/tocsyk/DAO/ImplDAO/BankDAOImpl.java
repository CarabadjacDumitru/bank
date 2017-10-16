package com.tocsyk.DAO.ImplDAO;


import com.tocsyk.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("bankDAO")
public class BankDAOImpl {

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
