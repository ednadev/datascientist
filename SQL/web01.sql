use scott;
CREATE TABLE member(
	id varchar(20) primary key,
    password varchar(30),
    name varchar(50),
    address varchar(100)
);
desc member;
select * from member;

INSERT INTO member(id, password, name, address) VALUES(1, 1234, '엔코아', '서초동');
