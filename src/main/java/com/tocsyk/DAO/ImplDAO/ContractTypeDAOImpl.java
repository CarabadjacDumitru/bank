package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.ContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("contractTypeDAO")
public class ContractTypeDAOImpl {
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
