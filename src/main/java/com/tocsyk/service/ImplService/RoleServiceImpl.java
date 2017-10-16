package com.tocsyk.service.ImplService;

import com.tocsyk.model.Role;
import com.tocsyk.service.AbstractService.AbstractRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements AbstractRoleService {
    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role getUserRoleByName(String name) {
        return null;
    }

    @Override
    public Role getUserRoleByID(int ID) {
        return null;
    }
}
