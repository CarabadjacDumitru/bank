package com.tocsyk.repository;

import com.tocsyk.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Customer> findAllCustomers() {
        return this.hibernateTemplate.loadAll(Customer.class);
    }

    public int registerCustomer(Customer customer) {
        Customer mergeCustomer = this.hibernateTemplate.merge(customer);
        return mergeCustomer.getID();
    }

    public Customer loadCustomerData(int customerID){
        return this.hibernateTemplate.load(Customer.class, customerID);
}

}
