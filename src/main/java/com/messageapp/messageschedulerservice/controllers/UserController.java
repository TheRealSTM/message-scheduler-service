package com.messageapp.messageschedulerservice.controllers;

import com.messageapp.messageschedulerservice.models.UserSignupInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<UserSignupInfo> signup(@RequestBody UserSignupInfo user) {
        System.out.println("We received a request to add a user: " + user);

        // For now, let's just return the user info
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<String> getUserByEmail(@PathVariable String email) {
        System.out.println("We received a request to retrieve the user associated with the email: " + email);
        return new ResponseEntity<>("User found for " + email, HttpStatus.OK);
    }
}
