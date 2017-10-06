package com.tocsyk.converters;

import com.tocsyk.models.Login;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMapper implements RowMapper<Login> {

    @Override
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {

        String userName = rs.getString("userName");
        String password = rs.getString("passWord");
        String email = rs.getString("eMail");
        int enabled = rs.getInt("enabled");
        String role = rs.getString("user_role");
/*
        while(rs.next()) {
            roles.add(rs.getString("roles"));
        }
*/
        return new Login(userName, password, role, enabled, email);
    }

}