CREATE DATABASE IF NOT EXISTS Tourism;
USE Tourism;

CREATE TABLE IF NOT EXISTS Travels (
    id INT AUTO_INCREMENT PRIMARY KEY,
    destination VARCHAR(255) NOT NULL,
    departure DATE NOT NULL,
    companions VARCHAR(255),
    memories TEXT
);