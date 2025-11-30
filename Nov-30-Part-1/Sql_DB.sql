create database wiproflux;
use wiproflux;
create table employ
(
   empno int primary key auto_increment,
   name varchar(30),
   gender varchar(30),
   dept varchar(30),
   desig varchar(30),
   basic numeric(9,2)
);

insert into employ select * from wipronov25.employ;
