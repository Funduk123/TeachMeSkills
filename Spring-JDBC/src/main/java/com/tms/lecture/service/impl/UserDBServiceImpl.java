package com.tms.lecture.service.impl;

import com.tms.lecture.domain.User;
import com.tms.lecture.mapper.UserMapper;
import com.tms.lecture.service.UserService;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
public class UserDBServiceImpl implements UserService {

    private final JdbcTemplate template;

    @Override
    public void save(User user) {
        template.update("insert into persons (id, login, password) values (?, ?, ?)",
                user.getUuid(),
                user.getLogin(),
                user.getPassword());
    }

    @Override
    public void update(User user) {
        template.update("update persons set login = ?, password = ? where id = ?",
                user.getLogin(),
                user.getPassword(),
                user.getUuid());
    }

    @Override
    public void delete(User user) {
        template.update("delete from persons where id = ?",
                user.getUuid());
    }

    @Override
    public User getById(UUID id) {
        return template.query("select * from persons where id = ?", new UserMapper(), id).get(0);
    }

    @Override
    public List<User> getAll() {
        return template.query("select * from persons", new UserMapper());
    }

    @Override
    public List<User> getByLogin(String login) {
        return template.query("select * from persons where login = ?", new UserMapper(), login);
    }

}
