package com.tocsyk.service.ImplService;

import com.tocsyk.model.AccountStatus;
import com.tocsyk.service.AbstractService.AbstractContractTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contractTypeService")
public class ContractTypeServiceImpl implements AbstractContractTypeService {
    @Override
    public List<AccountStatus> findAllContractType() {
        return null;
    }

    @Override
    public AccountStatus getContractTypeByName(String name) {
        return null;
    }

    @Override
    public AccountStatus getContractTypeByID(int ID) {
        return null;
    }
}
