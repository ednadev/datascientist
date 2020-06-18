CREATE TABLE `shopdb`.`item` (
  `item_id` INT NOT NULL,
  `item_name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `picture_url` VARCHAR(45) NOT NULL,
  `count` INT NULL,
  PRIMARY KEY (`item_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

desc item;

insert into item values(
1111,'딸기',4500,
'면역력을 강화시켜 질병에 효과적이다.',
'img/berry.jpg',0
);

insert into item values(
2222,'포도',5000,
'철분이 많고 조혈 작용을 해 임산부, 여성에게 일어나기 쉬운 빈혈을 예방한다',
'img/grape.jpg',0
);

insert into item values(
3333,'귤',4000,
'눈 건강 살리고 피로 회복, 혈압 안정시키는 비타민 A 가많다',
'img/gual.jpg',0
);

insert into item values(
4444,'키위',8000,
'키위 1개에 함유된 비타민 C는 오렌지의 2배. 비타민 E는 사과의 6배나 된다',
'img/kiui.jpg',0
);

insert into item values(
5555,'레몬',3000,
'구연산 비타민C가 풍부하여 피로회복에 도움이 된다.',
'img/lemon.jpg',0
);

select * from item;

UPDATE item SET count=2 WHERE item_id=3333;


-- -------------------------------------------------------------------------------------------------------------------------------


create table companysawon (company varchar(20),address varchar(50),
phone varchar(35),sawon_name varchar(30),position varchar(30),
email varchar(50),hp varchar(20));

desc companysawon;

INSERT INTO companysawon VALUES('LG', '서울 강남구', '02-123-1234', '강호동', '부장', 'aaa@naver.com', '010-222-3333');
INSERT INTO companysawon VALUES('KT', '경기도 분당', '031-123-1234', '이수근', '사원', 'bbb@naver.com', '010-111-3333');
INSERT INTO companysawon VALUES('SK', '부산 해운대', '051-123-1234', '이영자', '과장', 'ccc@naver.com', '010-444-3333');

SELECT * FROM companysawon;

create table company (company_id int primary key,
company varchar(20),address varchar(50),phone varchar(35));

desc company;

INSERT INTO company VALUES(10, 'LG', '서울 강남', '02-111-222');
INSERT INTO company VALUES(20, 'KT', '경기도 분당', '031-111-222');
INSERT INTO company VALUES(30, 'SK', '부산 해운대', '051-111-222');

SELECT * FROM company;

CREATE TABLE sawon (company_id int(10),
		     sawon_name varchar(20),
                              position varchar(30),
                              email varchar(30),
                              hp varchar(30),
                              foreign key(company_id) references company(company_id));
                              
desc sawon;

INSERT INTO sawon (company_id, sawon_name, position,email,hp)VALUES (10, '피준범','과장','junbumpi@ssafy@com','010-2345-1122');
INSERT INTO sawon (company_id, sawon_name, position,email,hp)VALUES (10, '이새봄','대리','bom@ssafy@com','010-4329-3355');
INSERT INTO sawon (company_id, sawon_name, position,email,hp)VALUES (30, '김아름','대리','beauty@ssafy@com','010-9901-8232');

SELECT * FROM sawon;

SELECT * FROM company c, sawon s WHERE c.company_id = s.company_id;


delete from sawon where sawon_name='피준범';

DROP TABLE sawon;

CREATE TABLE sawon (company_id int(10),
		     sawon_name varchar(20),
                              position varchar(30),
                              email varchar(30),
                              hp varchar(30),
                              foreign key(company_id) references company(company_id)
                              on delete cascade);
                              
delete from company where company_id=10;

select * from company;
select * from sawon;

CREATE TABLE shop(num int(5), sangpum varchar(30), color varchar(10), price int(10), ipgoday date);
CREATE TABLE client(num int(5), name varchar(20), age int(3), address varchar(50)); 

ALTER TABLE shop ADD constraint pk_shop primary key(num);
ALTER TABLE client ADD constraint pk_client primary key(num);

desc shop;
desc client;

INSERT INTO shop VALUES(111, '이어폰', '흰색', 12000, '2020-06-17');
INSERT INTO shop VALUES(222, '마스크', '회색', 1300, '2020-06-18');

select * from shop;

INSERT INTO client VALUES(01, '강호동', 44, '여의도');
INSERT INTO client VALUES(02, '이영자', 45, '서초동');

select * from client;

CREATE TABLE cart (shop_num int(5) not null,
                          client_num int(5) not null,
                          guipday date not null,
                          cnt int(5) not null,
constraint fk_shop foreign key(shop_num) references shop(num) on delete cascade,
constraint fk_client foreign key(client_num) references client(num) on delete cascade);

desc cart;

insert into cart values(111, 01, '2020-06-17', 2);
insert into cart values(222, 02, '2020-06-17', 50);     

select * from cart;

select * from shop s, client c, cart ca where s.num = ca.shop_num and c.num = ca.client_num;
select c.name "고객명", s.sangpum "상품명", s.color "색상", ca.cnt "갯수", s.price "가격", ca.cnt*s.price "총금액", c.age "나이", c.address "주소" from shop s, client c, cart ca where s.num = ca.shop_num and c.num = ca.client_num;

delete from shop where num=111;

insert into cart values(111, 01, '2020-06-17', 2);