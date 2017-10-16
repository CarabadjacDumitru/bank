package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Customer;

import java.util.List;

public interface AbstractCustomerDAO {
     List<Customer> findAllCustomers();
     int registerCustomer(Customer customer);
     Customer loadCustomerData(int customerID);
}
