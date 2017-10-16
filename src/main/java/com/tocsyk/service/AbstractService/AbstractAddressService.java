package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Address;

import java.util.List;

public interface AbstractAddressService {
    List<Address> findAllAddresses();
    int registerAddress(Address address);
    Address loadAddressByID(int addressID);
}

