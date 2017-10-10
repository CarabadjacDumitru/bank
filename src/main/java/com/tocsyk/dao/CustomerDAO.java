package com.tocsyk.dao;

import com.tocsyk.models.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Customer> findAllCustomer();
    void registerCustomer(Customer customer);
    Customer loadCustomerData(String customerName);
}
