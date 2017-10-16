package com.tocsyk.service.ImplService;

import com.tocsyk.model.Contact;
import com.tocsyk.service.AbstractService.AbstractContractTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contractTypeService")
public class ContractTypeServiceImpl implements AbstractContractTypeService {
    @Override
    public List<Contact.AccountStatus> findAllContractType() {
        return null;
    }

    @Override
    public Contact.AccountStatus getContractTypeByName(String name) {
        return null;
    }

    @Override
    public Contact.AccountStatus getContractTypeByID(int ID) {
        return null;
    }
}
