CREATE TABLE IF NOT EXISTS Users (
    userID BINARY(16) PRIMARY KEY,
    firstName VARCHAR(32) NOT NULL,
    lastName VARCHAR(32) NOT NULL,
    signUpDate TIMESTAMP,
    email VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR(64),
    phoneNumber VARCHAR(15)
);