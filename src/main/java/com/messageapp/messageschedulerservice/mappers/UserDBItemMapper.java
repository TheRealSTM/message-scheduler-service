package com.messageapp.messageschedulerservice.mappers;

import com.messageapp.messageschedulerservice.models.UserSignupInfo;
import com.messageapp.messageschedulerservice.persistance.users.UserItem;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UserDBItemMapper {
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
