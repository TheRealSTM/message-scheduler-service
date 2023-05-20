package com.messageapp.messageschedulerservice.persistance.users;

import lombok.Data;

import java.util.Date;

@Data
public class UserItem {
    final private String userID;

    final private Date signUpDate;

    final private String firstName;

    final private String lastName;

    final private String email;

    final private String password;

    final private String phoneNumber;
}
