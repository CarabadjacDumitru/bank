package com.tocsyk.dao;


import com.tocsyk.converters.LoginMapper;
import com.tocsyk.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;


@Transactional
@Service("userService")
public class LoginDAOImpl extends JdbcDaoSupport implements LoginDAO {

    @Autowired
    public LoginDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    @Override
    public Login validateLogin(Login login) {
        String sql = "select username, password, email ,enabled  from users where username='" + login.getUserName() + "' and password='" + login.getPassword() + "'";
        List<Login> logins = this.getJdbcTemplate().query(sql, new LoginMapper());
        return logins.size() > 0 ? logins.get(0) : null;
    }

    @Override
    public Login findLogin(String name) {
        String sql = "select username, password, email ,enabled from users where username= ?";
        Object[] params = new Object[] { name};
        return this.getJdbcTemplate().queryForObject(sql, params, new LoginMapper());
    }


    public void saveLogin(Login login) {
        String sql = "INSERT INTO USERS  (USERNAME,PASSWORD,EMAIL, ENABLED) values(?, ?, ?, ?) ";
        Object[] params = new Object[]{login.getUserName(), login.getPassword(),login.getEmail(), 1};
        this.getJdbcTemplate().update(sql,params);
    }

    public void updateLogin(Login login) {
        String sql = "UPDATE USERS u  set USERNAME = ?, PASSWORD = ? , EMAIl = ?, ENABLED = ? where ID = ?";
        Object[] params = new Object[]{login.getUserName(), login.getPassword(), login.getEnabled(),login.getEmail(), login.getId()};
        this.getJdbcTemplate().update(sql, params);
    }


    public List<Login> findAllLogins() {
        String sql = "Select u.Username,u.Password,u.Email,u.Enabled  from Users u ";
        Object[] params = new Object[]{" "};
        LoginMapper mapper = new LoginMapper();
        List<Login> loginList = this.getJdbcTemplate().query(sql, params, mapper);
        return loginList;
    }


    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "select distinct r.user_role from user_roles r  where r.Username = ? ";
        Object[] params = new Object[]{userName};
        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
        return roles;
    }


    @Override
    public List<String> getRoles() {
        String sql = "select distinct user_role from user_roles ";
        List<String> roles = this.getJdbcTemplate().queryForList(sql,  String.class);
        return roles;
    }


}

