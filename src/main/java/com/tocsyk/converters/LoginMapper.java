package com.tocsyk.converters;

import com.tocsyk.models.Login;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements RowMapper<Login> {

    @Override
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {

        String userName = rs.getString("Username");
        String password = rs.getString("Password");

        return new Login(userName, password);
    }

}