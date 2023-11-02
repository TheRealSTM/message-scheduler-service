package com.messageapp.messageschedulerservice.persistance.message;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * The MessageItem class represents a scheduled message in the system.
 * It encapsulates all the properties associated with a scheduled message including its scheduling details.
 */
@Data
@Builder
public class MessageItem {
    final private UUID messageID;

    final Date messageRequestDate;

    final String email;

    final String messageStartDate;

    final String message;

    final String destinationPhoneNumber;

    final String callbackPhoneNumber;

    final String messageFrequency;

    final Boolean isActive;
}
