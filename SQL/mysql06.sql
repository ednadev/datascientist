-- JOIN
SELECT * FROM emp;
SELECT distinct deptno FROM emp;
SELECT * FROM dept;

-- 특정 사원이 소속된 부서의 정보를 검색(사원의 정보 + 부서의 정보)
/*
Cartesian Product
단순 데이타의 곱으로 결과를 산출하는 방식
14 x 4 = 56

Cartesian Product가 도출되는 경우
1) 조인 조건을 안줬거나 
2) 조인 조건을 잘못줬거나

join 조건 부여하는 방법  (양쪽 테이블을 연결하는 컬럼의 존재 : deptno)
1) where 절을 이용해서 각각 테이블의 공통의 컬럼을 명시한다
2) where emp.deptno = dept.deptno
*/
SELECT * FROM emp, dept;

-- 1) 컬럼명을 일일이 명시해야한다...불필요한 컬럼이 출력되는 것을 방지한다. 
SELECT * FROM emp, dept WHERE emp.deptno = dept.deptno;

-- 2) deptno 컬럼이 어느 테이블에 있는지 모호...컬럼명앞에 table alias를 부여한다.
SELECT empno, ename, sal, deptno, dname, loc 
FROM emp, dept 
WHERE emp.deptno = dept.deptno;

-- 3) 컬럼명 앞에 테이블명을 일일히 붙이는 것이 넘 번거롭다.
SELECT emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname, dept.loc 
FROM emp, dept 
WHERE emp.deptno = dept.deptno;

-- 4) 
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname, d.loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 사원의 이름, 급여, 부서번호, 부서명을 검색. 단 급여가 2000이상이고 30번 부서에 한해서만..
-- where 절에서 조인 조건과 함께 비조인 조건을 사용한다.
SELECT e.ename, e.sal, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.sal >= 2000
AND e.deptno = 30;

-- SELF JOIN 
SELECT empno, ename, mgr FROM emp WHERE ename='BLAKE'; -- e
SELECT empno, ename FROM emp WHERE empno=7839; -- m

-- BLAKE라는 사원의 상사의 이름을 검색..사원번호, 사원이름, 상사번호, 상사이름 
-- 특정 사원의 상사의 이름을 검색
-- 1) 
SELECT empno, ename, mgr FROM emp; -- 해당 사원의 상사번호를 검색
SELECT empno, ename FROM emp; -- 위의 상사번호가 사원번호인 사람의 이름을 검색

-- 2)
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

-- 3)
SELECT * FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

-- 4)
SELECT e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno;

-- 5)
SELECT e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) m
WHERE e.mgr = m.empno
AND e.ename = 'BLAKE';

-- OUTER JOIN
/*
	A, B 테이블을 조인할 경우, 조건에 맞지 않는 데이타는 디스플레이 되지 않는데..
    이 경우도 디스플레이 하고 싶을 때 outer join을 사용한다. 
    
    OUTER JOIN 종류
    1) LEFT OUTER JOIN  2) RIGHT OUTER JOIN  3) FULL OUTER JOIN
    (데이타가 어느쪽에 있는가에 따라서 종류의 이름이 정해짐)
*/
-- 사원의 이름, 부서번호, 부서이름을 검색...
SELECT e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 1) 위 경우에 RIGHT OUTER JOIN을 사용
-- 조인수행시 우측테이블(DEPT)이 기준이 되어서 결과를 생산하도록 해준다 
SELECT e.ename, e.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno; -- LEFT로도 변경해서 확인

SELECT e.ename, e.deptno, d.dname
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno; 

-- 특정 사원의 상사의 이름을 검색...13줄 검색...
/*
self 조인의 결과 KING의 사원정보가 빠져있다.
KING 은 MGR이 NULL이라서.. 

*/
SELECT concat(e.ename, '의 매니저는 ', m.ename, '입니다') Info
FROM emp e LEFT OUTER JOIN emp m
ON e.mgr = m.empno;

-- A 10, 20, 30 FULL OUTER JOIN B 10, 20, 40 -- 10, 20, 30, 40 도출됨
-- FULL OUTER JOIN 이 실행되지 않음으로 union 연산자를 mysql에서 사용해야 한다. 
/*
FULL OUTER JOIN을 실습할 수 있는 간단한 테이블을 만들고 예제를 풀어 보도록 한다
*/
CREATE TABLE outer1(sawonid int);
CREATE TABLE outer2(sawonid int);

INSERT INTO outer2 VALUES(10);
INSERT INTO outer2 VALUES(20);
INSERT INTO outer2 VALUES(30);

SELECT * FROM outer1;
SELECT * FROM outer2;

-- FULL OUTER JOIN 사용
SELECT sawonid FROM outer1
-- FULL OUTER JOIN 
UNION
SELECT sawonid FROM outer2;