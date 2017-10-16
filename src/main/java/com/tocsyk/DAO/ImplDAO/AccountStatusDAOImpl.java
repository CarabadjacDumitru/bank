package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountStatusDAO")
public class AccountStatusDAOImpl {
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
