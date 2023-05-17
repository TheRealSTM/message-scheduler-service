package com.messageapp.messageschedulerservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/message/{messageID}")
    public ResponseEntity<String> getMessage(@PathVariable String messageID) {
        System.out.println("We received a request to retrieve the message associated with the messageID: " + messageID);
        return new ResponseEntity<>("Message found for " + messageID, HttpStatus.OK);
    }
}
