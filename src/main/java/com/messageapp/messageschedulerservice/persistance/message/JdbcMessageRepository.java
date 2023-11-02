package com.messageapp.messageschedulerservice.persistance.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * The JdbcMessageRepository class implements the MessageRepository interface and provides JDBC operations
 * for managing scheduled messages.
 */
@Repository
public class JdbcMessageRepository implements MessageRepository {

    private static final String QUERY_ADD_MESSAGE =
            "insert into ScheduledMessages (messageID, messageRequestDate, email, messageStartDate, message, destinationPhoneNumber, callbackPhoneNumber, messageFrequency, isActive) values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String QUERY_GET_MESSAGE_BY_EMAIL = "select * from ScheduledMessages where email=?";

    private final JdbcTemplate jdbc;

    /**
     * Constructs a new JdbcMessageRepository with a given JdbcTemplate.
     *
     * @param jdbc JdbcTemplate used for JDBC operations
     */
    @Autowired
    public JdbcMessageRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public void addScheduledMessage(MessageItem messageItem) {
        jdbc.update(QUERY_ADD_MESSAGE,
                messageItem.getMessageID(),
                messageItem.getMessageRequestDate(),
                messageItem.getEmail(),
                messageItem.getMessageStartDate(),
                messageItem.getMessage(),
                messageItem.getDestinationPhoneNumber(),
                messageItem.getCallbackPhoneNumber(),
                messageItem.getMessageFrequency(),
                messageItem.getIsActive());
    }

    @Override
    public List<MessageItem> getScheduledMessagesByEmail(String email) {
        return jdbc.query(QUERY_GET_MESSAGE_BY_EMAIL, this::mapRowToMessage);
    }

    private MessageItem mapRowToMessage(ResultSet rs, int rowNum) throws SQLException {
        return MessageItem.builder()
                .email(rs.getString("email"))
                .messageRequestDate(rs.getDate("messageRequestDate"))
                .messageStartDate(rs.getString("messageStartDate"))
                .message(rs.getString("message"))
                .destinationPhoneNumber(rs.getString("destinationPhoneNumber"))
                .callbackPhoneNumber(rs.getString("callbackPhoneNumber"))
                .messageFrequency(rs.getString("messageFrequency"))
                .isActive(rs.getBoolean("isActive"))
                .build();
    }
}
