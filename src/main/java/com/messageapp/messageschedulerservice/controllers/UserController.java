package com.messageapp.messageschedulerservice.controllers;

import com.messageapp.messageschedulerservice.mappers.UserDBItemMapper;
import com.messageapp.messageschedulerservice.models.UserSignupInfo;
import com.messageapp.messageschedulerservice.persistance.user.UserItem;
import com.messageapp.messageschedulerservice.persistance.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling HTTP requests related to User operations. It handles mapping of HTTP requests
 * to specific methods and constructing HTTP responses to be returned to the client.
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private final UserDBItemMapper userDBItemMapper;

    /**
     * Endpoint for user sign-up.
     * This method receives a POST request with a UserSignupInfo object in the body.
     * It transforms the UserSignupInfo object into a UserItem object, then adds the UserItem to the repository.
     * Finally, it responds with a 201 CREATED status code along with the original UserSignupInfo object in the body.
     *
     * @param user UserSignupInfo object provided in the request body.
     * @return ResponseEntity containing the original UserSignupInfo object and a CREATED status code.
     */
    @PostMapping("/user")
    public ResponseEntity<UserSignupInfo> signup(@Valid @RequestBody UserSignupInfo user) {
        System.out.println("We received a request to add a user: " + user);
        // TODO: Add validations to check if the user is already a user

        UserItem userItem = userDBItemMapper.mapUserSignupInfoToUserItem(user);
        userRepository.addUser(userItem);

        System.out.println("User: " + userItem + " was added.");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /**
     * Endpoint for fetching a user by their email.
     * This method receives a GET request with an email as a path variable.
     * It fetches the UserItem object associated with this email from the repository.
     * If a user is found, it responds with a 200 OK status code and the UserItem object in the body.
     * If no user is found, it responds with a 404 NOT FOUND status code.
     *
     * @param email Email of the user to be fetched, provided as a path variable.
     * @return ResponseEntity containing the UserItem object (if found) and the appropriate status code.
     */
    @GetMapping("/user/{email}")
    public ResponseEntity<UserItem> getUserByEmail(@PathVariable String email) {
        System.out.println("We received a request to retrieve the user associated with the email: " + email);
        UserItem user;
        try {
            user = userRepository.getUserByEmail(email);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("We could not find a user associated with the email: " + email);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        System.out.println("The following user(" + user + ") was retrieved.");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
