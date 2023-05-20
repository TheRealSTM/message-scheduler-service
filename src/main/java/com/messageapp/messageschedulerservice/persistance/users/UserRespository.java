package com.messageapp.messageschedulerservice.persistance.users;

public interface UserRespository {
    public UserItem getUser(String email);

    public void addUser(UserItem userItem);
}
