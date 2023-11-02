package com.messageapp.messageschedulerservice.controllers;

import com.messageapp.messageschedulerservice.mappers.ScheduledMessageDBItemMapper;
import com.messageapp.messageschedulerservice.models.MessageCreationRequest;
import com.messageapp.messageschedulerservice.persistance.message.MessageItem;
import com.messageapp.messageschedulerservice.persistance.message.MessageRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    private final ScheduledMessageDBItemMapper messageMapper;

    @PostMapping("/message")
    public ResponseEntity<MessageCreationRequest> addMessageRequest(@Valid @RequestBody MessageCreationRequest request) {
        System.out.println("We received a request to create the following message request: " + request);
        // TODO: add some validations of the messages
        MessageItem messageItem = messageMapper.mapMessageCreationRequestToMessageItem(request);
        messageRepository.addScheduledMessage(messageItem);
        System.out.println("ScheduleMessage: " + messageItem + " was added.");
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("/message/{email}")
    public ResponseEntity<List<MessageItem>> getAllMessages(@PathVariable String email) {
        System.out.println("We received a request to retrieve the message associated with the email: " + email);


        List<MessageItem> messages;
        try {
            messages = messageRepository.getScheduledMessagesByEmail(email);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("We could not find any messages associated with the provided email: " + email);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}
