CREATE DATABASE library_db;
USE library_db;
CREATE TABLE books (
    book_id INT PRIMARY KEY,
    book_name VARCHAR(100),
    author VARCHAR(100),
    category VARCHAR(50),
    available_copies INT
);