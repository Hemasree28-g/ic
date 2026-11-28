USE college_management;

CREATE TABLE students (
    student_id INT,
    student_name VARCHAR(50),
    age INT,
    gender VARCHAR(100),
    department VARCHAR(100),
    city VARCHAR(50),
    marks INT,
    admission_date DATE
);
DESC students;

ALTER TABLE students DROP COLUMN gender;

ALTER TABLE students DROP COLUMN city;

ALTER TABLE students DROP COLUMN marks;

ALTER TABLE students DROP COLUMN admission_date;

ALTER TABLE students ADD COLUMN email VARCHAR(100);
