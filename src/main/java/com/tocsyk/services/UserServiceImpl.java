package com.tocsyk.services;


import com.tocsyk.dao.LoginDAO;
import com.tocsyk.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginDAO dao;

    /*@Autowired
    private PasswordEncoder passwordEncoder;*/

    public Login findById(int id) {
        return dao.findById(id);
    }

    public Login findBySSO(String sso) {
        Login login = dao.findBySSO(sso);
        return login;
    }

    public void saveLogin(Login login) {
        /*login.setPassword(passwordEncoder.encode(login.getPassword()));*/
        login.setPassword(login.getPassword());
        dao.save(login);
    }

    public void updateLogin(Login login) {
        Login entity = dao.findById(login.getId());
        if (entity != null) {
            entity.setSsoId(login.getSsoId());
            if (!login.getPassword().equals(entity.getPassword())) {
                /*entity.setPassword(passwordEncoder.encode(login.getPassword()));*/
                entity.setPassword(login.getPassword());
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

    public List<Login> findAllLogins() {
        return dao.findAllLogins();
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        Login user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

}