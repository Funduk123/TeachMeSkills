package com.tms.lecture.mapper;

import com.tms.lecture.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("id");
        String login = rs.getString("login");
        String password = rs.getString("password");
        return new User(UUID.fromString(id), login, password);
    }

}
