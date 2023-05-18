package com.messageapp.messageschedulerservice.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Represents information required for a user to sign up.
 */
@Data
@RequiredArgsConstructor
public class UserSignupInfo {
    final private String name;
    final private String email;
    final private String password;
}
