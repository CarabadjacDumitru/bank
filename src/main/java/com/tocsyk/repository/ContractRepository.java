package com.tocsyk.repository;

import com.tocsyk.hibernate.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ContractRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Contract> findAllContracts(){
        return this.hibernateTemplate.loadAll(Contract.class);
    }

    public int registerBranch(Contract contract){
        Contract mergeContract = this.hibernateTemplate.merge(contract);
        return mergeContract.getID();
    }

    public Contract loadContractData(int contractID){
        return this.hibernateTemplate.load(Contract.class, contractID);
    }
}
