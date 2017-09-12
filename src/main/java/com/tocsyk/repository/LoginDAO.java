package com.tocsyk.repository;

import com.tocsyk.models.Login;

import java.util.List;

public interface LoginDAO {

    public Login findLogin(String userName);

    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);

}