package com.messageapp.messageschedulerservice.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Represents the necessary information for creating a message request.
 */
@Data
@RequiredArgsConstructor
public class MessageCreationRequest {
    final String messageStartDate;
    final String message;
    final String destinationPhoneNumber;
    final String callbackPhoneNumber;
    final String messageFrequency;
}
