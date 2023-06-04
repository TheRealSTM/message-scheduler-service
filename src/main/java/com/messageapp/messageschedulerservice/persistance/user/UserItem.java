package com.messageapp.messageschedulerservice.persistance.user;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class UserItem {
    final private UUID userID;

    final private Date signUpDate;

    final private String firstName;

    final private String lastName;

    final private String email;

    final private String password;

    final private String phoneNumber;
}
