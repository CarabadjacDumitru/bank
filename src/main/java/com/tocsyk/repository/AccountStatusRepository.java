package com.tocsyk.repository;

import com.tocsyk.hibernate.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class AccountStatusRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<AccountStatus> findAllAccountStatus(){
        return this.hibernateTemplate.loadAll(AccountStatus.class);
    }

    public int registerBranch(AccountStatus accountStatus){
        AccountStatus mergeAccountStatus = this.hibernateTemplate.merge(accountStatus);
        return mergeAccountStatus.getID();
    }

    public AccountStatus loadAccountStatusData(int accountStatus){
        return this.hibernateTemplate.load(AccountStatus.class, accountStatus);
    }
}
