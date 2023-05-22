package com.messageapp.messageschedulerservice.persistance.users;

public interface UserRespository {
    public UserItem getUserByEmail(String email);

    public void addUser(UserItem userItem);
}
