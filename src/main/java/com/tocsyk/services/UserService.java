package com.tocsyk.services;

import com.tocsyk.models.Login;
import java.util.List;


public interface UserService {
    Login findById(int id);
    Login findBySSO(String sso);
    void saveLogin(Login user);
    void updateLogin(Login user);
    void deleteUserBySSO(String sso);
    List<Login> findAllLogins();
    boolean isUserSSOUnique(Integer id, String sso);

}