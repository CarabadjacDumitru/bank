package com.tocsyk.dao;


import com.tocsyk.converters.LoginMapper;
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
        String sql = "select username, password, email ,enabled  from users where username='" + login.getUserName() + "' and password='" + login.getPassword() + "'";
        List<Login> logins = jdbcTemplate.query(sql, new LoginMapper());
        return logins.size() > 0 ? logins.get(0) : null;
    }

    @Override
    public Login findLogin(String name) {
        String sql = "select username, password, email ,enabled from users where username= ?";
        Object[] params = new Object[] { name};
        return jdbcTemplate.queryForObject(sql, params, new LoginMapper());
    }


    public void registerLogin(Login login) {
        String sql = "INSERT INTO USERS  (USERNAME,PASSWORD,EMAIL, ENABLED) values(?, ?, ?, ?) ";
        Object[] params = new Object[]{login.getUserName(), login.getPassword(),login.getEmail(), 1};
        jdbcTemplate.update(sql,params);
    }

    public void updateLogin(Login login) {
        String sql = "UPDATE USERS u  set USERNAME = ?, PASSWORD = ? , EMAIl = ?, ENABLED = ? where USERNAME = ?";
        Object[] params = new Object[]{login.getUserName(), login.getPassword(),login.getEmail(), login.getEnabled(), login.getUserName()};
        jdbcTemplate.update(sql, params);
    }

    public void deleteLogin(String username) {
        String sql = "DELETE FROM USERS WHERE USERNAME = ?";
        Object[] params = new Object[]{username};
        jdbcTemplate.update(sql, params);
    }


    public List<Login> findAllLogins() {
        String sql = "Select u.Username,u.Password,u.Email,u.Enabled  from Users u ";
        Object[] params = new Object[]{" "};
        LoginMapper mapper = new LoginMapper();
        //List<Login> loginList = jdbcTemplate.query(sql, params, mapper);
        List<Login> users = jdbcTemplate.query(sql,mapper);
        return users ;
    }


    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "select distinct r.user_role from user_roles r  where r.Username = ? ";
        Object[] params = new Object[]{userName};
        List<String> roles = jdbcTemplate.queryForList(sql, params, String.class);
        return roles;
    }


    @Override
    public List<String> getRoles() {
        String sql = "select distinct user_role from user_roles ";
        List<String> roles = jdbcTemplate.queryForList(sql,  String.class);
        return roles;
    }


}

