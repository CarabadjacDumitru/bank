package com.tocsyk.dao;

import com.tocsyk.models.Login;
import java.util.List;


public interface LoginDAO {
    public Login findLogin(String userName);
    public List<String> getUserRoles(String userName);
}