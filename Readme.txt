DB para java

create database CRUD;

use CRUD;

CREATE TABLE USUARIOS(
codigo int primary key auto_increment,
data1 varchar(60),
resultado varchar(120),
peso int not null,
altura int not null);

insert into usuarios (data1,resultado,peso,altura) values
('12-12-2005','Joao',65,121);

select * from usuarios;

drop table CRUD.usuarios;