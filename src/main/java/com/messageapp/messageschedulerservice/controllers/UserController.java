package com.messageapp.messageschedulerservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/{email}")
    public ResponseEntity<String> getUserByEmail(@PathVariable String email) {
        System.out.println("We received a request to retrieve the user associated with the email: " + email);
        return new ResponseEntity<>("User found for " + email, HttpStatus.OK);
    }
}
