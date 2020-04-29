CREATE DATABASE paises;

USE paises;
 
CREATE TABLE pais (
	id int auto_increment primary key,
	nome varchar(100),
	populacao bigint,
	area double
);