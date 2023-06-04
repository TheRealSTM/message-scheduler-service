package com.messageapp.messageschedulerservice.mappers;

import com.messageapp.messageschedulerservice.models.UserSignupInfo;
import com.messageapp.messageschedulerservice.persistance.user.UserItem;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * This class is responsible for mapping UserSignupInfo to UserItem.
 */
@Component
public class UserDBItemMapper {

    /**
     * This method is responsible for transforming a UserSignupInfo object into a UserItem object.
     *
     * @param user The UserSignupInfo object that should be transformed.
     * @return A UserItem object containing the data from the UserSignupInfo and some additional fields.
     */
    public UserItem mapUserSignupInfoToUserItem(UserSignupInfo user) {
        return UserItem.builder()
                .userID(UUID.randomUUID())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                // There may be a better version of date to use, but this is fine for now.
                .signUpDate(new Date())
                .build();
    }
}
