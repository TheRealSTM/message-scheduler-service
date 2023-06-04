package com.messageapp.messageschedulerservice.persistance.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * A repository class that provides JDBC operations for the Users.
 * It implements {@link UserRespository} interface methods for this purpose.
 */
@Repository
public class JdbcUserRepository implements UserRespository {

    private static final String QUERY_GET_USER_BY_EMAIL = "select * from Users where email=?";
    private static final String QUERY_ADD_USER =
            "insert into Users (userID, signUpDate, firstName, lastName, email, password, phoneNumber) values " +
                    "(?, ?, ?, ?, ?, ?, ?)";

    private final JdbcTemplate jdbc;

    /**
     * Constructs a new JdbcUserRepository with a given JdbcTemplate.
     *
     * @param jdbc JdbcTemplate used for JDBC operations
     */
    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Fetches a UserItem from the Users table based on the provided email.
     *
     * @param email Email of the user to retrieve
     * @return UserItem object representing the user record
     */
    @Override
    public UserItem getUserByEmail(String email) {
        return jdbc.queryForObject(QUERY_GET_USER_BY_EMAIL, this::mapRowToUser, email);
    }

    /**
     * Adds a new user to the Users table.
     *
     * @param userItem the UserItem object containing the details of the user to add
     */
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

