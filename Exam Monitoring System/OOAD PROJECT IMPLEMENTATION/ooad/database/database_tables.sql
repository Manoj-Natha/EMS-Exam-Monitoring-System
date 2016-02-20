drop database ems;

create database ems;
use ems;

create table student (
roll_no int(10) not null unique auto_increment,
f_name varchar (50) not null,
l_name varchar (50) not null,
dob varchar(25) not null,
gender varchar (10) not null,
address varchar (255) not null,
mobile varchar (10) not null,
email varchar (50) unique not null,
city varchar(50) not null,
zip varchar(10),
country varchar(50) not null,
username varchar(75) not null unique,
password varchar(35) not null,
primary key(email)
);






create table exam_cell (
uname varchar(25) not null unique,
password varchar(25) not null
);

desc exam_cell;

insert into exam_cell values('PRANATSAR','123');

create table register (
name varchar(75) not null,
date varchar(25) not null,
location varchar(30) not null,
timing varchar(15) not null,
foreign key(name) references student(username) on delete cascade on update cascade
);

desc register;

create table result (
roll_no int(10) not null unique,
username varchar(50) not null ,
marks int(3) not null,
foreign key(username) references  register(name) on delete cascade on update cascade,
foreign key(roll_no) references student(roll_no) on delete cascade on update cascade
);

desc result;

alter table student auto_increment=1000000001;

alter table result add column email varchar(80) not null;

desc result;

select * from result;

select * from student;

insert into result values('1000000001','saravanan','45','saravanancse13@gmail.com');

insert into result values('1000000002','natha','100','natha.manoj@gmail.com');





