package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Role;

import java.util.List;

public interface AbstractRoleService {
    List<Role> getAllRoles();
    Role getUserRoleByName(String name);
    Role getUserRoleByID(int ID);

}