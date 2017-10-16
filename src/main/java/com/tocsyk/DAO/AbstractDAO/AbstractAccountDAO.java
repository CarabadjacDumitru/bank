package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Account;

public interface AbstractAccountDAO {
    Account getAccount(int ID);
    void registerAccount(Account account);
}
