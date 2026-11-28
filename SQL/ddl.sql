show databases;
create database uni;
use uni;
create table unistu(
 id int primary key,
 name varchar (20),
 age int,
 deparment varchar(20),
 city varchar(20)
 );
 desc unistu;
INSERT INTO unistu VALUES
(102, 'Priya', 22, 'ECE', 'Bangalore'),
(103, 'Arun', 20, 'CSE', 'Chennai'),
(104, 'Sneha', 21, 'IT', 'Hyderabad'),
(105, 'Kiran', 23, 'ECE', 'Vijayawada'),
(106, 'Anjali', 20, 'IT', 'Bangalore');
select age,name from unistu;
select distinct  deparment from unistu; 
select * from unistu where id=102;
update unistu set city ='Mumbai' where id =102;
delete from unistu where id=106;
select * from unistu;
alter table unistu add email varchar(100);
alter table unistu modify name varchar(105);
alter table unistu rename column city to address;
alter table unistu drop column phone;

select count(*) from unistu;
select sum(age)from unistu;
select avg(age)from unistu;
select max(age)from unistu;
select min(age)from unistu;

select deparment ,count(*)from unistu group by deparment ;
select deparment ,max(age)from unistu group by deparment ;
select deparment ,min(age)from unistu group by deparment ;

select address,count(*)from unistu group by address;

select deparment ,count(*)as soteded from unistu group by deparment having count(*)>1;
