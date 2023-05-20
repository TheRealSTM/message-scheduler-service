package com.messageapp.messageschedulerservice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;


/**
 * Represents information required for a user to sign up.
 */
@Data
@RequiredArgsConstructor
public class UserSignupInfo {
    @NotNull
    @Size(min = 1, max = 30)
    final private String firstName;

    @NotNull
    @Size(min = 1, max = 30)
    final private String lastName;

    @NotNull
    @Email
    final private String email;

    @NotNull
    @Size(min = 8, max = 32)
    final private String password;

    @NotNull
    @Pattern(regexp="^[0-9]{10}$", message="Invalid phone number")
    final private String phoneNumber;
}
