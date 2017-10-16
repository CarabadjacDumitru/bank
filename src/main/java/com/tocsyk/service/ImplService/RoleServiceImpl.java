package com.tocsyk.service.ImplService;

import com.tocsyk.DAO.ImplDAO.RoleDAOImpl;
import com.tocsyk.model.Role;
import com.tocsyk.service.AbstractService.AbstractRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements AbstractRoleService {

    @Autowired
    RoleDAOImpl roleDAO;

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role getUserRoleByName(String name) {
        return roleDAO.getUserRoleByName(name);
    }

    @Override
    public Role getUserRoleByID(int ID) {
        return roleDAO.getUserRoleByID(ID);
    }
}
