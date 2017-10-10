package com.tocsyk.dao;

import com.tocsyk.models.Contract;
import com.tocsyk.models.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Contract> findAllContracts();
    void registerCustomer(Customer customer);
    Customer loadCustomerData(String customerName);
    float getCustomerBalance();
}
