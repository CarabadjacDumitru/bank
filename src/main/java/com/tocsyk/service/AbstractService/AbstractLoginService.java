package com.tocsyk.service.AbstractService;

import com.tocsyk.model.Login;

import java.util.List;


public interface AbstractLoginService {
    List<Login> getAllLogins();

    Login getLoginById(int ID);
    Login getLoginByName(String name);

    void registerLogin(Login login);
    void updateLogin(Login login);
    void deleteLogin(Login login);


}
