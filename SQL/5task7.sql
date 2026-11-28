CREATE DATABASE bank_db;

USE bank_db;

CREATE TABLE bank_accounts (
    account_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    account_type VARCHAR(30),
    balance DOUBLE
);