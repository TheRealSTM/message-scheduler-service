package com.messageapp.messageschedulerservice.persistance.message;


import java.util.List;

public interface MessageRepository {
    public void addScheduledMessage(MessageItem messageItem);

    public List<MessageItem> getScheduledMessagesByEmail(String email);
}
