package com.tocsyk.dao;


import com.tocsyk.models.Role;
import java.util.List;


public interface RoleDAO {
    List<Role> findAll();
    Role findByType(String type);
    Role findById(int id);
}