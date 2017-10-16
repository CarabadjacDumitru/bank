package com.tocsyk.service.AbstractService;

import com.tocsyk.model.AccountStatus;
import java.util.List;

public interface AbstractAccountStatusService {
    List<AccountStatus> findAllAccountStatus();
    AccountStatus getAccountStatusByName(String name);
    AccountStatus getAccountStatusByID(int ID);
}
