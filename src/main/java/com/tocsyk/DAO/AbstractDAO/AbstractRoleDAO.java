package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Role;
import java.util.List;

public interface AbstractRoleDAO {
    List<Role> getAllRoles();
    Role getUserRoleByName(String name);
    Role getUserRoleByID(int ID);

}
