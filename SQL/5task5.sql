CREATE DATABASE coll_management;
USE coll_management;
CREATE TABLE student_marks (
    mark_id INT,
    student_id INT,
    subject VARCHAR(100),
    marks INT,
    result VARCHAR(20)
);
desc student_marks;