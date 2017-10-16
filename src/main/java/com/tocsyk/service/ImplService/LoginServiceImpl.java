package com.tocsyk.service.ImplService;

import com.tocsyk.DAO.ImplDAO.LoginDAOImpl;
import com.tocsyk.model.Login;
import com.tocsyk.service.AbstractService.AbstractLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LoginService")
public class LoginServiceImpl implements AbstractLoginService {

    @Autowired
    LoginDAOImpl loginDAO;

    @Override
    public List<Login> getAllLogins() {
        return loginDAO.getAllLogins();
    }

    @Override
    public Login getLoginById(int ID) {
        return loginDAO.getLoginById(ID);
    }

    @Override
    public Login getLoginByName(String name) {
        return loginDAO.getLoginByName(name);
    }

    @Override
    public void registerLogin(Login login) {
        loginDAO.registerLogin(login);
    }

    @Override
    public void updateLogin(Login login) {
        loginDAO.updateLogin(login);
    }

    @Override
    public void deleteLogin(Login login) {
        loginDAO.deleteLogin(login);
    }
}
