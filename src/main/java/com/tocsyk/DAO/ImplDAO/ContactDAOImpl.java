package com.tocsyk.DAO.ImplDAO;

import com.tocsyk.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("contactDAO")
public class ContactDAOImpl {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Contact> findAllContacts(){
        return this.hibernateTemplate.loadAll(Contact.class);
    }

    public int registerBranch(Contact contact){
        Contact mergeContact = this.hibernateTemplate.merge(contact);
        return mergeContact.getID();
    }

    public Contact loadContactData(int contactID){
        return this.hibernateTemplate.load(Contact.class, contactID);
    }
}
