CREATE TABLE IF NOT EXISTS Users (
    userID VARCHAR(64) PRIMARY KEY,
    firstName VARCHAR(32) NOT NULL,
    lastName VARCHAR(32) NOT NULL,
    signUpDate TIMESTAMP,
    email VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR(64),
    phoneNumber VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS ScheduledMessages (
    messageID VARCHAR(64) PRIMARY KEY,
    messageRequestDate TIMESTAMP,
    email VARCHAR(128) NOT NULL,
    messageStartDate TIMESTAMP,
    message VARCHAR(1024) NOT NULL,
    destinationPhoneNumber VARCHAR(15),
    callbackPhoneNumber VARCHAR(15),
    messageFrequency VARCHAR(32),
    isActive BOOLEAN
);