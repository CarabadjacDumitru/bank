package com.tocsyk.repository;

import com.tocsyk.hibernate.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ContactRepository {
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
