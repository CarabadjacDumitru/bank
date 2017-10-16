package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountStatusDAO")
public class AccountStatusDAOImpl {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Contact.AccountStatus> findAllAccountStatus(){
        return this.hibernateTemplate.loadAll(Contact.AccountStatus.class);
    }

    public int registerBranch(Contact.AccountStatus accountStatus){
        Contact.AccountStatus mergeAccountStatus = this.hibernateTemplate.merge(accountStatus);
        return mergeAccountStatus.getID();
    }

    public Contact.AccountStatus loadAccountStatusData(int accountStatus){
        return this.hibernateTemplate.load(Contact.AccountStatus.class, accountStatus);
    }
}
