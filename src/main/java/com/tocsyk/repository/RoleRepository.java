package com.tocsyk.repository;

import com.tocsyk.hibernate.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class RoleRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Role> getAllRoles() {
        return this.hibernateTemplate.loadAll(Role.class);
    }

    public Role getRole(int ID) {
        return this.hibernateTemplate.load(Role.class, ID);
    }

    public int registerBank(Role role) {
        Role mergeRole = this.hibernateTemplate.merge(role);
        return mergeRole.getID();
    }
}
