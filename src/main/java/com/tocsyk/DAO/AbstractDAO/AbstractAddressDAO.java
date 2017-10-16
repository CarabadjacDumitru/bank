package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Address;

import java.util.List;

public interface AbstractAddressDAO {

    List<Address> findAllAddresses();
    int registerAddress(Address address);
    Address loadAddressByID(int addressID);
}
