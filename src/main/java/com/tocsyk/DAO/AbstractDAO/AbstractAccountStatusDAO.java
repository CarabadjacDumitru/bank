package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.AccountStatus;
import java.util.List;

public interface AbstractAccountStatusDAO {
    List<AccountStatus> findAllAccountStatus();
    AccountStatus getAccountStatusByName(String name);
    AccountStatus getAccountStatusByID(int ID);
}
