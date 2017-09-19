package com.tocsyk.services;

import com.tocsyk.models.Role;
import java.util.List;

public interface RoleService {
    Role findById(int id);
    Role findByType(String type);
    List<Role> findAll();
}