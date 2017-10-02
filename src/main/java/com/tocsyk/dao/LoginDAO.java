package com.tocsyk.dao;

import com.tocsyk.models.Login;
import java.util.List;


public interface LoginDAO {
    Login validateLogin(Login login);
    Login findLogin(String name);
    void saveLogin(Login login);
    void updateLogin(Login login);

    List<String> getRoles();
    List<String> getUserRoles(String name);
    List<Login> findAllLogins();
}