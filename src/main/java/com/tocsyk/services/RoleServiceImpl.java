package com.tocsyk.services;


import com.tocsyk.dao.RoleDAO;
import com.tocsyk.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userProfileService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO dao;

    public Role findById(int id) {
        return dao.findById(id);
    }

    public Role findByType(String type) {
        return dao.findByType(type);
    }

    public List<Role> findAll() {
        return dao.findAll();
    }
}