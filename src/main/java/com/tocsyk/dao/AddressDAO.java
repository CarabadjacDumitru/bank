package com.tocsyk.dao;

import com.tocsyk.models.Address;


public interface AddressDAO {
    void registerAddress(Address address);
    Address loadAddress(String adressName);
}
