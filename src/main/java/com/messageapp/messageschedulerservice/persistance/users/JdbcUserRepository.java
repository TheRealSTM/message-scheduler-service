package com.messageapp.messageschedulerservice.persistance.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.UUID;

@Repository
public class JdbcUserRepository implements UserRespository {

    private static final String QUERY_GET_USER_BY_EMAIL = "select * from Users where email=?";
    private static final String QUERY_ADD_USER =
            "insert into Users (userID, signUpDate, firstName, lastName, email, password, phoneNumber) values " +
            "(?, ?, ?, ?, ?, ?, ?)";

    private JdbcTemplate jdbc;
    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public UserItem getUserByEmail(String email) {
        return jdbc.queryForObject(QUERY_GET_USER_BY_EMAIL, this::mapRowToUser, email);

    }

    @Override
    public void addUser(UserItem userItem) {
        jdbc.update(QUERY_ADD_USER,
                userItem.getUserID(),
                userItem.getSignUpDate(),
                userItem.getFirstName(),
                userItem.getLastName(),
                userItem.getEmail(),
                userItem.getPassword(),
                userItem.getPhoneNumber());
    }

    private UserItem mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("UUID retrieved from DB: " + rs.getString("userID"));
        return UserItem.builder()
                .userID(UUID.fromString(rs.getString("userID")))
                .signUpDate(rs.getDate("signUpDate"))
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .email(rs.getString("email"))
                .phoneNumber(rs.getString("phoneNumber"))
                .build();
    }

}
