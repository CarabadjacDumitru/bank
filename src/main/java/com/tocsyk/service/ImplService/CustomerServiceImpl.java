package com.tocsyk.service.ImplService;

import com.tocsyk.model.Customer;
import com.tocsyk.service.AbstractService.AbstractCustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements AbstractCustomerService {
    @Override
    public List<Customer> findAllCustomers() {
        return null;
    }

    @Override
    public int registerCustomer(Customer customer) {
        return 0;
    }

    @Override
    public Customer loadCustomerData(int customerID) {
        return null;
    }
}
