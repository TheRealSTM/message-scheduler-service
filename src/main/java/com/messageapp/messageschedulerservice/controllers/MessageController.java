package com.messageapp.messageschedulerservice.controllers;

import com.messageapp.messageschedulerservice.models.MessageCreationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @PostMapping("/message")
    public ResponseEntity<MessageCreationRequest> addMessage(@Valid @RequestBody MessageCreationRequest request) {
        System.out.println("We received a request to create the following message request: " + request);

        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("/message/{messageID}")
    public ResponseEntity<String> getMessage(@PathVariable String messageID) {
        System.out.println("We received a request to retrieve the message associated with the messageID: " + messageID);
        return new ResponseEntity<>("Message found for " + messageID, HttpStatus.OK);
    }
}
