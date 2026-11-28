CREATE DATABASE company_management;
USE company_management;
CREATE TABLE employees (
    employee_id INT,
    employee_name VARCHAR(100),
    designation VARCHAR(50),
    salary DOUBLE,
    department VARCHAR(50)
);
desc employees;