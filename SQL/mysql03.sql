create table person(
	ssn int primary key,
    name varchar(20),
    address varchar(50)
);

drop table person;
desc person;

select * from person;

INSERT INTO person VALUES(333, '정우성', '방배동');