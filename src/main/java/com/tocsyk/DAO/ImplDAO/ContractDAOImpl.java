package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contractDAO")
public class ContractDAOImpl {
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
