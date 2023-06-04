package com.messageapp.messageschedulerservice.persistance.user;

/**
 * This interface defines the contract for user-related data operations.
 * The primary function of a repository is to encapsulate the storage specific logic, providing a cleaner abstraction to manage the data layer.
 * It isolates the application/business layer from the data access layer.
 */
public interface UserRepository {

    /**
     * Retrieves a UserItem by their email.
     *
     * @param email Email of the user to retrieve.
     * @return The UserItem associated with the provided email. Implementing classes will define what happens if no user with the provided email exists.
     */
    public UserItem getUserByEmail(String email);

    /**
     * Adds a new UserItem to the repository.
     *
     * @param userItem The userItem to add.
     */
    public void addUser(UserItem userItem);
}
