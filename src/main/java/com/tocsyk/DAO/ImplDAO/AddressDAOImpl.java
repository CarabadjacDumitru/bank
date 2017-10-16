package com.tocsyk.DAO.ImplDAO;


import com.tocsyk.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("addressDAO")
public class AddressDAOImpl {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Address> findAllAddresses(){
        return this.hibernateTemplate.loadAll(Address.class);
    }

    public int registerBranch(Address address){
        Address mergeAddress = this.hibernateTemplate.merge(address);
        return mergeAddress.getID();
    }

    public Address loadAddressData(int addressID){
        return this.hibernateTemplate.load(Address.class, addressID);
    }
}
