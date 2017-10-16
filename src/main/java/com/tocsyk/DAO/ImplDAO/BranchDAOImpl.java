package com.tocsyk.DAO.ImplDAO;


import com.tocsyk.model.Branch;
import com.tocsyk.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("branchDAO")
public class BranchDAOImpl {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Customer> findAllCustomers(){
        return this.hibernateTemplate.loadAll(Customer.class);
    }

    public int registerBranch(Branch branch){
        Branch mergeBranch = this.hibernateTemplate.merge(branch);
        return mergeBranch.getID();
    }

    public Branch loadBranchData(int branchID){
        return this.hibernateTemplate.load(Branch.class, branchID);
    }

}
