DROP DATABASE IF EXISTS example;

CREATE DATABASE example;

USE example;

CREATE TABLE board_tb
(
	bno 			INT PRIMARY KEY AUTO_INCREMENT,
    btitle 			VARCHAR(40) NOT NULL,
    bwriter 		VARCHAR(40) NOT NULL,
    bcontent 		VARCHAR(100) NOT NULL,
    bwrite_date 	DATETIME NOT NULL
);

INSERT INTO board_tb (btitle, bwriter, bcontent, bwrite_date)
VALUES ("첫 번째 글", "admin", "첫 번째 내용", now()),
("두 번째 글", "admin", "두 번째 내용", now()),
("세 번째 글", "admin", "세 번째 내용", now());
