create database airport_bd;

use airport_bd;



create table if not exists Employee(
id bigint not null auto_increment,
surname varchar(255),
firstname varchar(255),
primary key(id)
);

create table if not exists Country(
id bigint not null auto_increment,
code bigint ,
name varchar(255),
primary key(id)
);

create table if not exists Language(
id bigint not null auto_increment,
code bigint ,
name varchar(255),
primary key(id)
);

create table if not exists Airports(
id bigint not null auto_increment,
name varchar(255),
primary key(id)
);
