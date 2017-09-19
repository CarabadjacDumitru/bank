package com.tocsyk.dao.LoginOld;

import com.tocsyk.models.Login;
import com.tocsyk.models.Role;


import java.util.List;

public interface LoginDAO {
    Login findLogin(String userName);
    void  updateLogin(Login login);
    void  addLogin(Login newLogin);
    void  removeLogin(Login newLogin);
    List<Role> getUserRoles();
}

