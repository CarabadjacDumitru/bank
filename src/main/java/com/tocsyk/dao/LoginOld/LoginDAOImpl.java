package com.tocsyk.dao.LoginOld;

import com.tocsyk.models.Login;
import com.tocsyk.models.Role;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class LoginDAOImpl implements LoginDAO {

    private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Login findLogin(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        Login p = (Login)session.load(Login.class, new String(userName));
        logger.info("Person loaded successfully, Person details="+p);
        return p;
    }

    @Override
    public void updateLogin(Login login) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(login);
        logger.info("Person updated successfully, Person Details=" + login);
    }

    @Override
    public void addLogin(Login newLogin) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(newLogin);
        logger.info("Login saved successfully, Person Details=" + newLogin);
    }

    @Override
    public void removeLogin(Login remLogin) {
        Login loginForRem = this.findLogin(remLogin.getUserName());
        if (loginForRem != null) {
            this.sessionFactory.getCurrentSession().delete(loginForRem);
        }
    }

    @Override
    public List<Role> getUserRoles(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> RoleList = session.createQuery("from user_roles").list();
        for (Role p : RoleList) {
            logger.info("Role List::" + p);
        }
        return RoleList;
    }
}

