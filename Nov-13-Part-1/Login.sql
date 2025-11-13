use wipronov25;

drop table if exists login;

create table login
(
  userName varchar(30) primary key,
  password varchar(30)
);

Insert into Login(username,password)
values('Divyansh','Prashant'),
('Poonam','Eknath'),
('Satya','Prakash');