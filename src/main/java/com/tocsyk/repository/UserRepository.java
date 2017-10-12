package com.tocsyk.repository;

import com.tocsyk.hibernate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<User> getAllUsers() {
        return this.hibernateTemplate.loadAll(User.class);
    }

    public User getUser(int ID) {
        return this.hibernateTemplate.load(User.class, ID);
    }

    public int registerBank(User user) {
        User mergeUser = this.hibernateTemplate.merge(user);
        return mergeUser.getID();
    }
}
