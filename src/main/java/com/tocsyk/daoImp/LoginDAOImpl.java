package com.tocsyk.daoImp;


import com.tocsyk.converters.LoginMapper;
import com.tocsyk.dao.LoginDAO;
import com.tocsyk.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;


@Transactional
@Service
public class LoginDAOImpl extends JdbcDaoSupport implements LoginDAO {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    public LoginDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    @Override
    public Login validateLogin(Login login) {
        String sql = "select 1  from users where username='" + login.getUserName() + "' and password='" + login.getPassword() + "'";
        List<Login> logins = jdbcTemplate.query(sql, new LoginMapper());
        return logins.size() > 0 ? logins.get(0) : null;
    }

    @Override
    public Login findLogin(String name) {
        String sql = "select u.username, u.password, u.email ,u.enabled,ur.user_role as rOle from users u, user_roles ur where u.username=ur.username and u.username= ?";
        Object[] params = new Object[] { name};
        return jdbcTemplate.queryForObject(sql, params, new LoginMapper());
    }


    public void registerLogin(Login login) {
        String sql1 = "INSERT INTO USERS (USERNAME,PASSWORD,EMAIL, ENABLED) values(?, ?, ?, ?) ";
        String sql2 = "INSERT INTO USER_ROLES (USERNAME,USER_ROLE) values(?, ?) ";
        Object[] params1 = new Object[]{login.getUserName(), login.getPassword(),login.geteMail(), login.getEnabled()};
        jdbcTemplate.update(sql1,params1);
        Object[] params2 = new Object[]{login.getUserName(),login.getRole()};
        jdbcTemplate.update(sql2,params2);
    }

    public void updateLogin(Login login) {
        String sql1 = "UPDATE USERS u  set USERNAME = ?, PASSWORD = ? , EMAIl = ?, ENABLED = ? where USERNAME = ?";
        Object[] params1 = new Object[]{login.getUserName(), login.getPassword(),login.geteMail(), login.getEnabled(), login.getUserName()};
        jdbcTemplate.update(sql1, params1);
        String sql2 = "UPDATE USER_ROLES set USER_ROLE = ? where USERNAME = ?";
        Object[] params2 = new Object[]{login.getRole(), login.getUserName()};
        jdbcTemplate.update(sql2, params2);
    }

    public void deleteLogin(String username) {
        String sql1 = "DELETE FROM USERS WHERE USERNAME = ?";
        Object[] params1 = new Object[]{username};
        jdbcTemplate.update(sql1, params1);
        String sql2 = "DELETE FROM USER_ROLES WHERE USERNAME = ?";
        jdbcTemplate.update(sql2, params1);
    }


    public List<Login> findAllLogins() {
        String sql = "select u.Username,u.Password,u.Email,u.Enabled, ur.USER_ROLE as rOle from users u , user_roles ur  WHERE u.username = ur.username";
        LoginMapper mapper = new LoginMapper();
        List<Login> users = jdbcTemplate.query(sql,mapper);
        return users ;
    }


    @Override
    public String getUserRole(String userName) {
        String sql = "select  r.user_role from user_roles r  where r.Username = ? ";
        Object[] params = new Object[]{userName};
        String role = jdbcTemplate.queryForObject(sql, params, String.class);
        return role;
    }


    @Override
    public List<String> getRoles() {
        String sql = "select distinct ROLE_NAME from ROLES";
        List<String> roles = jdbcTemplate.queryForList(sql,  String.class);
        return roles;
    }


}

