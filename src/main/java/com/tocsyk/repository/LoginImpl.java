package com.tocsyk.repository;


import com.tocsyk.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Service
@Transactional
public class LoginImpl extends JdbcDaoSupport implements LoginDAO {

    @Autowired
    public LoginImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    @Override
    public Login findLogin(String userName) {
        String sql = "Select u.Username,u.Password "//
                + " from Users u where u.Username = ? ";

        Object[] params = new Object[]{userName};
        LoginMapper mapper = new LoginMapper();
        try {
            Login userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<String> getUserRoles(String userName) {
        String sql = "Select r.User_Role "//
                + " from User_Roles r where r.Username = ? ";

        Object[] params = new Object[]{userName};

        List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);

        return roles;
    }

}
