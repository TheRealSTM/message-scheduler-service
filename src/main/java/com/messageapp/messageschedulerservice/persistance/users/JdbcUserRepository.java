package com.messageapp.messageschedulerservice.persistance.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRespository {

    private JdbcTemplate jdbc;
    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public UserItem getUser(String email) {
        throw new UnsupportedOperationException("Method has not been implemented yet.");
    }

    @Override
    public void addUser(UserItem userItem) {
        throw new UnsupportedOperationException("Method has not been implemented yet.");
    }

}
