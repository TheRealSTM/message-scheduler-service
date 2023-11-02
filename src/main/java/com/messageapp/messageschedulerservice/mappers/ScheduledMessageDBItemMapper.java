package com.messageapp.messageschedulerservice.mappers;

import com.messageapp.messageschedulerservice.models.MessageCreationRequest;
import com.messageapp.messageschedulerservice.persistance.message.MessageItem;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ScheduledMessageDBItemMapper {
    public MessageItem mapMessageCreationRequestToMessageItem(MessageCreationRequest request) {
        return MessageItem.builder()
                .messageID(UUID.randomUUID())
                .messageRequestDate(new Date())
                .email(request.getEmail())
                .messageStartDate(request.getMessageStartDate())
                .message(request.getMessage())
                .destinationPhoneNumber(request.getDestinationPhoneNumber())
                .callbackPhoneNumber(request.getCallbackPhoneNumber())
                .messageFrequency(request.getMessageFrequency())
                .isActive(Boolean.TRUE)
                .build();
    }
}
