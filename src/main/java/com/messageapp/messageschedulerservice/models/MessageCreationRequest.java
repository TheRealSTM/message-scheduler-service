package com.messageapp.messageschedulerservice.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Represents the necessary information for creating a message request.
 */
@Data
@RequiredArgsConstructor
public class MessageCreationRequest {
    @NotNull
    final String messageStartDate;

    @NotNull
    final String message;

    @NotNull
    @Pattern(regexp="^[0-9]{10}$", message="Invalid phone number")
    final String destinationPhoneNumber;

    @NotNull
    @Pattern(regexp="^[0-9]{10}$", message="Invalid phone number")
    final String callbackPhoneNumber;

    @NotNull
    final String messageFrequency;
}
