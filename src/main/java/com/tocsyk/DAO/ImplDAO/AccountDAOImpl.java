package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.DAO.AbstractDAO.AbstractAccountDAO;
import com.tocsyk.DAO.AbstractDAO.AbstractDAO;
import com.tocsyk.model.Account;
import org.springframework.stereotype.Repository;

@Repository("accountDAO")
public class AccountDAOImpl extends AbstractDAO<Integer, Account> implements AbstractAccountDAO {


    public Account getAccount(int ID) {
        return getByKey(ID);
    }

    public void registerAccount(Account account) {
        persist(account);
    }

}
