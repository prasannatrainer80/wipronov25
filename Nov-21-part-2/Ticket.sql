drop table if exists ticket;

create table Ticket
(
    Id INT Primary Key auto_increment,
    title varchar(30),
    description varchar(30),
    customerName varchar(30),
    customerMobile varchar(30),
    status varchar(30)
);

Insert into Ticket(Title,Description,CustomerName,
customerMobile,status) values('Lets C','C Language Book',
'Vatsal','848284845','open'),
('Java Programming','Simon Copy','Satya','9772344','closed'),
('Java Black Book','Hudson','Swetha','884823445','open')