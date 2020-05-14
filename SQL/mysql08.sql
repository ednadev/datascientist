


CREATE TABLE encore(no int primary key auto_increment, name varchar(30));
desc encore;

INSERT INTO encore(name) VALUES('송강호');
INSERT INTO encore(name) VALUES('전도연');
INSERT INTO encore(name) VALUES('설경구');

SELECT * FROM encore;

CREATE TABLE bank(
	id varchar(20) primary key, 
    name varchar(30),
    bankname varchar(30),
    balance int(10)
);

INSERT INTO bank(id, name, bankname, balance) VALUES('111', '윤아', '신한은행', 1000000);
INSERT INTO bank(id, name, bankname, balance) VALUES('222', '승기', '국민은행', 2000000);

DELETE FROM bank;

SELECT * FROM bank;


UPDATE bank SET balance=balance+500000 WHERE


