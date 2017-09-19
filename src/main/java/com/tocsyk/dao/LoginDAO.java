package com.tocsyk.dao;

import com.tocsyk.models.Login;
import java.util.List;


public interface LoginDAO {
    Login findById(int id);
    Login findBySSO(String sso);
    void save(Login user);
    void deleteBySSO(String sso);
    List<Login> findAllLogins();
}