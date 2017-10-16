package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Customer;

import java.util.List;

public interface AbstractCustomerService {
    List<Customer> findAllCustomers();
    int registerCustomer(Customer customer);
    Customer loadCustomerData(int customerID);
}
