package com.messageapp.messageschedulerservice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * Represents information required for a user to sign up.
 */
@Data
@RequiredArgsConstructor
public class UserSignupInfo {
    @NotNull
    @Size(min = 2, max = 30)
    final private String name;

    @NotNull
    @Email
    final private String email;

    @NotNull
    @Size(min = 8, max = 32)
    final private String password;
}
