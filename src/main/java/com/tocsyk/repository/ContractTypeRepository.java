package com.tocsyk.repository;

import com.tocsyk.hibernate.ContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class ContractTypeRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<ContractType> findAllContractType(){
        return this.hibernateTemplate.loadAll(ContractType.class);
    }

    public int registerBranch(ContractType contractType){
        ContractType mergeContractType = this.hibernateTemplate.merge(contractType);
        return mergeContractType.getID();
    }

    public ContractType loadContractTypeData(int contractType){
        return this.hibernateTemplate.load(ContractType.class, contractType);
    }
}
