DROP DATABASE IF EXISTS contactBook;

CREATE DATABASE contactBook;
USE contactBook;

CREATE TABLE contact
(
ContactId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
FirstName varchar(255),
MiddleName varchar(255),
LastName varchar(255),
Email varchar(255),
Major varchar(255)
);

INSERT INTO contact (FirstName,MiddleName,LastName,Email,Major)
VALUES ('Marshall','C','Brown','mbrown62@elon.edu','Computer Science'),
('Haris','','Cesko','hcesko@elon.edu','Computer Science'),
('Maddie','C','Chili','mchili@elon.edu','Computer Science'),
('Keith','A','Davis','kdavis36@elon.edu','Computer Science'),
('Zareh','H','Deirmendjian','zdeirmendjian@elon.edu','Computer Science'); 
