drop database if exists wipronov25;

create database wipronov25;

use wipronov25;

create table Employ
(
   Empno INT Primary Key,
   Name varchar(30),
   Gender ENUM('MALE','FEMALE'),
   Dept varchar(30),
   Desig varchar(30),
   Basic Numeric(9,2)
);

Insert into Employ(Empno,Name,Gender,Dept,Desig,Basic)
values(1,'Vatsal','MALE','Java','Programmer',72344),
  (2,'Avinash','MALE','Sql','Expert',77422),
  (3,'Satya','MALE','Java','Manager',84822),
  (4,'Kanchan','FEMALE','Sql','DBA',88424),
  (5,'Bhavana','FEMALE','Java','Trainee',72223);