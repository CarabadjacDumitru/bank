package com.tocsyk.DAO.AbstractDAO;

import com.tocsyk.model.Login;
import com.tocsyk.model.Role;

import java.util.List;

public interface AbstractLoginDAO {

    List<Login> getAllLogins();

    Login getLoginById(int ID);
    Login getLoginByName(String name);

    void registerLogin(Login login);
    void updateLogin(Login login);
    void deleteLogin(Login login);


}
