-- 1. 문자관련 함수 : concat(), substr()
SELECT concat(ename, ' is a ', job) Message FROM emp;

SELECT ename, substr(hiredate, 1, 4) 년도 FROM emp;
SELECT ename, substring(hiredate, 1, 4) 년도 FROM emp;
SELECT ename, substr(hiredate, 6, 2) 월 FROM emp;
SELECT ename, substr(hiredate, 9, 2) 일 FROM emp;
SELECT ename, year(hiredate) 년도, month(hiredate) 월 FROM emp;
SELECT hiredate FROM emp;

-- 2. 숫자관련함수 : abs(), mod(분자, 분모), round(), ceiling(), floor(), truncate()
-- BLAKE와 SMITH 의 월급의 차이를 검색
SELECT DISTINCT abs((SELECT sal FROM emp WHERE ename='SMITH')-(SELECT sal FROM emp WHERE ename='BLAKE')) 월급차이
FROM emp;

-- 사원번호가 홀수인 사원의 정보를 검색...mod()
SELECT empno FROM emp;
SELECT empno, ename FROM emp WHERE mod(empno, 2)=1;

-- 업무가 salesman인 모든 사원에 대해서 comm에 대한 급여 비율의 나머지를 검색하세여
SELECT ename, sal, comm, MOD(sal, comm) FROM emp WHERE job='SALESMAN';

-- round(), ceiling(), floor(), truncate()
SELECT round(45.923, 2);
SELECT round(45.923);
SELECT round(45.923, 0);
SELECT round(45.923, -1);

-- SELECT floor(45.923, 2);
SELECT floor(45.923); -- 자릿수를 지정할 수 없다.

SELECT truncate(45.923, 2);
SELECT truncate(45.923, 0);
SELECT truncate(45.923); -- 자릿수를 지정해줘야 한다.


-- 3. 날짜관련함수 : NOW, SYSDATE, CURDATE, current_time
SELECT now();
SELECT sysdate();
SELECT curdate(); -- 년, 월, 일
SELECT current_time();

-- 막내 오세훈이 오늘까지 살아온 일수를 구하세요 : 변환함수
-- SELECT curdate() - ('1997-06-19') 살아온날; -- 날짜-문자 : 계산 X
-- SELECT curdate() - str_to_date('1997-06-19', '%Y-%m-%d') 살아온날;
-- SELECT curdate() - date('1997-06-19') 살아온날;

SELECT datediff(curdate(), '1988-05-26');

-- emp 테이블에서 모든 사원들이 지금까지 근무한 일수 
SELECT ename, datediff(curdate(), hiredate) 근무일수 FROM emp;

-- emp 테이블에서 모든 사원들이 지금까지 근무한 Weeks;
SELECT ename, floor(datediff(curdate(), hiredate)/7) Weeks FROM emp;

-- 오늘부터 그이를 만난지 100일째 되는 날을 검색....100일뒤 
SELECT date_add(curdate(), interval 100 day);

-- 날짜 - 날짜 = 일수
-- 날짜 + 숫자 = 날짜 | 날짜 - 숫자 = 날짜

-- 4. 그룹함수 : COUNT(), SUM(), AVG(), MAX(), MIN()
SELECT count(*) FROM emp; -- * : 모든 컬럼이 가지는 row수
SELECT count(-1) FROM emp; -- 맨 마지막 행 리턴 (*보다 -1 사용하는 게 더 정확하다)

SELECT count(empno) FROM emp;
SELECT count(MGR) FROM emp; -- null값은 그룹함수 연산에서 제외된다. 

SELECT min(hiredate) 가장빠른입사일, max(hiredate)  가장최근입사일 FROM emp;

SELECT sum(sal) 사원총급여 FROM emp;
SELECT round(avg(sal)) 사원총평균급여 FROM emp;

-- 업무가 MANAGER 인 사원의 평균급여를 검색
SELECT round(avg(sal)) 평균급여
FROM emp
WHERE job='MANAGER';

-- 모든 사원의 보너스의 평균을 검색 
SELECT round(avg(ifnull(comm,0))) 평균보너스
FROM emp;

-- 사원테이블에서 모든 부서의 갯수를 출력 
SELECT count(distinct deptno)
FROM emp;

-- 부서번호가 10번 이거나 20번인 사원의 인원수를 검색하세요 
SELECT count(deptno) FROM emp WHERE deptno=10 or deptno=20;

-- 사원번호가 7369이거나 7521이거나 7876인 사원의 정보를 검색 
SELECT * FROM emp WHERE empno=7369 or empno=7521 or empno=7876;

SELECT count(deptno) FROM emp WHERE deptno in(10, 20);
SELECT * FROM emp WHERE empno in(7369, 7521, 7876);

-- 부서번호가 10번이 아니고 20번이 아닌 사원의 인원수를 검색하세요
SELECT count(deptno) FROM emp WHERE deptno!=10 and deptno!=20;
SELECT count(deptno) FROM emp WHERE deptno not in(10, 20);

-- 각 부서의 평균급여를 검색...AVG()
-- 그룹함수에 적용되지 않은 컬럼이 select절에 나열되면 반드시 group by 절뒤에 명시해줘야 한다. 
SELECT deptno, avg(sal) FROM emp;

SELECT deptno, avg(sal) FROM emp GROUP BY deptno;

-- 부서별 급여의 총합
SELECT deptno, sum(sal) FROM emp GROUP BY deptno;

-- 입사년도별 사원의 인원수를 출력 ...COUNT()
SELECT year(hiredate) 입사년도, count(-1) 인원수 FROM emp GROUP BY 입사년도;

-- 부서별 평균급여를 구하는데 20번 부서는 제외하고 구하세요
SELECT deptno, round(avg(sal)) 
FROM emp 
WHERE deptno not in(20) -- !=20
GROUP BY deptno
ORDER BY deptno;

-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균급여를 구하세요.
SELECT deptno, round(avg(sal)) 
FROM emp 
WHERE round(avg(sal))>=2000 
GROUP BY deptno
ORDER BY deptno;
-- 1. WHERE 절에서는 그룹함수를 못쓴다. 시점이 다름! 그룹핑 하기 전 조건은 where, 그룹핑 하고 조건을 주려면 having!
-- 2. HAVING절은 반드시 GROUP BY절 뒤에 온다.
SELECT deptno, round(avg(sal))
FROM emp
GROUP BY deptno
HAVING round(avg(sal))>=2000 
ORDER BY deptno;

-- 부서별 평균급여가 2000달러 이상인 부서의 부서번호와 평균급여를 구하세요.
-- 이때 단 10번 부서는 제외합니다. 
SELECT deptno, round(avg(sal))
FROM emp
WHERE deptno != 10 
GROUP BY deptno
HAVING round(avg(sal))>=2000 
ORDER BY deptno;


/*
1. 테이블 생성
create table myTest(
	id tinyint not null,
    name varchar(10),
    addr varchar(50),
    birthDate date
);

2. 테이블에 값 입력 
INSERT INTO myTest (id, name, addr, birthDate) VALUES(1, 'A', 'A', curdate());
INSERT INTO myTest (id, name, addr, birthDate) VALUES(1, 'A', 'A', '2020-01-11');

3. 테이블 값 삭제
DELETE FROM myTest; // 모든 행이 삭제됨....
DELETE FROM myTest WHERE id=1;

4. 테이블 컬럼값 수정
UPDATE myTest SET 수정할 컬럼명 = 컬럼값, 수정할 컬럼명 = 컬럼값 WHERE id=1;
*/
show databases;
use scott; -- Database changed
DROP TABLE mytable;
CREATE TABLE mytable(
	id tinyint not null,
    name varchar(10),
    addr varchar(50),
    birthDate date
);
desc mytable;
select * from mytable;

-- C : Create
INSERT INTO mytable (id, name, addr, birthDate) VALUES(1, '아이유', '서초동', '1989-02-11');
INSERT INTO mytable VALUES(2, '임영웅', '신사동', curdate());
INSERT INTO mytable VALUES(3, '장만호', '신사동', curdate());

-- R : SELECT

-- U : Update
UPDATE mytable set addr='여의도', name='임영장' WHERE id=2;

-- D : Delete
DELETE FROM mytable; -- 조건을 주지 않으면 다 지워진다.
DELETE FROM mytable WHERE id=3;

DROP TABLE test01;
CREATE TABLE test01(
	num int auto_increment primary key,
    name varchar(20),
    age tinyint,
    height decimal(5, 1),
    birthday datetime,
    hiredate date
);

desc test01;
SELECT * FROM test01;

-- 데이타 추가하기
INSERT INTO test01 (name, age, height, birthdate, hiredate) VALUES('강호동', 44, 182.5, now(), now());
INSERT INTO test01 (name, age, height, birthdate, hiredate) VALUES('이영자', 45, 169.5, now(), now());
INSERT INTO test01 (name, age, height, birthdate, hiredate) VALUES('김준현', 37, 179.5, now(), now());

-- 컬럼명 변경 : ALTER
ALTER TABLE test01 change birthday birthdate datetime;

-- 컬럼 데이타 타입 변경하기 : ALTER
ALTER TABLE test01 change birthdate birthdate date;

-- 
desc test01;
SELECT * FROM test01;
--

-- num이 3번인 데이타를 삭제
DELETE FROM test01 WHERE num=3;

-- num이 2번인 데이타의 키와 나이를 수정
-- 기본키는 update의 대상이 아니다...기본키를 제외한 나머지 컬럼들이 수정의 대상.
UPDATE test01 SET birthdate=now(), height=183, age='45' WHERE num=2;


/*

delete from test01; 
-- 데이터만 다 지워지고, 테이블은 남아있다. 지울때 한줄씩 지운다.. auto_increment가 이어서 시작
truncate table test01; 
-- 데이터만 다 지워지고, 테이블은 남아있다. 잘라버린다고 생각! 속도가 delete보다 더 빠르다. auto_increment가 1부터 다시 시작
drop table test01; 
-- 구조조차도 지워버린다.

SQL
::
DM(Manupulation)L - insert, update, delete (데이터 변경)
DD(Define)L - create, drop, alter (테이블 변경)

*/