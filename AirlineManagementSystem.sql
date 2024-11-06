Create Database airlinemanagementsystem;

use airlinemanagementsystem;

show tables;

create table login(username varchar(20), password varchar(20));
insert into login values("admin","admin");
select * from login;

create table passenger(Name varchar(30),Nationality varchar(30), Phone varchar(18),	Address varchar(50),Aadhar varchar(18),Gender varchar(10),email varchar(50));
select*from passenger;
Select * from passenger where Adher ='tfadhar';
Select * from passenger where source = 'src' and destination ='dest';

create table flight(f_code varchar(5),f_name varchar(20),source varchar(20),destination varchar(20));
insert into flight values("1001","AI-1212","Delhi","Mumbai");
insert into flight values("1002","AI-1453","Delhi","Goa");
insert into flight values("1003","AI-1112","Mumbai","Chennai");
insert into flight values("1004","AI-3222","Delhi","Amritsar");
insert into flight values("1005","AI-1212","Delhi","Ayodha");
select*from flight;

CREATE TABLE reservation (
    pnr VARCHAR(20) PRIMARY KEY,
    ticket_number VARCHAR(20),
    aadhar VARCHAR(20),
    name VARCHAR(50),
    nationality VARCHAR(30),
    flight_name VARCHAR(30),
    flight_code VARCHAR(10),
    source VARCHAR(30),
    destination VARCHAR(30),
    departure_date DATE
);
Select*from reservation;


create table cancel(PNR varchar(20),NAME varchar(40),CancelNo varchar(20),Fcode varchar(20),Date varchar(30));

