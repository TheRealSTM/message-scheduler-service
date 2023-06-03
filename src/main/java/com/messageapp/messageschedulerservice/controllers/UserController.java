package com.messageapp.messageschedulerservice.controllers;

import com.messageapp.messageschedulerservice.mappers.UserDBItemMapper;
import com.messageapp.messageschedulerservice.models.UserSignupInfo;
import com.messageapp.messageschedulerservice.persistance.users.UserItem;
import com.messageapp.messageschedulerservice.persistance.users.UserRespository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRespository userRespository;

    private final UserDBItemMapper userDBItemMapper;

    @PostMapping("/user")
    public ResponseEntity<UserSignupInfo> signup(@Valid @RequestBody UserSignupInfo user) {
        System.out.println("We received a request to add a user: " + user);
        // TODO: Add validatons to check if the user is already a user

        UserItem userItem = userDBItemMapper.mapUserSignupInfoToUserItem(user);
        userRespository.addUser(userItem);

        System.out.println("User: " + user + " was added.");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<String> getUserByEmail(@PathVariable String email) {
        System.out.println("We received a request to retrieve the user associated with the email: " + email);
        return new ResponseEntity<>("User found for " + email, HttpStatus.OK);
    }
}
