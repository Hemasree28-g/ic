CREATE DATABASE company_db;
USE company_db;
CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100),
    department VARCHAR(50),
    salary DOUBLE
);
desc employee;

INSERT INTO employee VALUES
(101, 'Ravi', 'IT', 30000),
(102, 'Priya', 'HR', 35000),
(103, 'Kiran', 'Finance', 40000),
(104, 'Sneha', 'IT', 45000),
(105, 'Arun', 'Sales', 32000);
