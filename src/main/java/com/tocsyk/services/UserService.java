package com.tocsyk.services;

import com.tocsyk.models.Login;
import java.util.List;


public interface UserService {
    Login findById(int id);
    Login findBySSO(String sso);
    void saveUser(Login user);
    void updateUser(Login user);
    void deleteUserBySSO(String sso);
    List<Login> findAllUsers();
    boolean isUserSSOUnique(Integer id, String sso);

}