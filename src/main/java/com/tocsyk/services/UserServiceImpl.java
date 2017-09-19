package com.tocsyk.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tocsyk.dao.LoginDAO;
import com.tocsyk.models.Login;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginDAO dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Login findById(int id) {
        return dao.findById(id);
    }

    public Login findBySSO(String sso) {
        Login user = dao.findBySSO(sso);
        return user;
    }

    public void saveUser(Login login) {
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        dao.save(login);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(Login login) {
        Login entity = dao.findById(login.getId());
        if (entity != null) {
            entity.setSsoId(login.getSsoId());
            if (!login.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(login.getPassword()));
            }
            entity.setFirstName(login.getFirstName());
            entity.setLastName(login.getLastName());
            entity.setEmail(login.getEmail());
            entity.setRoles(login.getRoles());
        }
    }


    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    public List<Login> findAllUsers() {
        return dao.findAllLogins();
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        Login user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

}