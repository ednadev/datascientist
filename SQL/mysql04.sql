-- Sub Query
/*
1. 서브쿼리는 반드시 ()로 쌓여져야 한다.
2. 서브쿼리가 먼저 돌아간 결과값을 가지고 메인쿼리가 실행된다.
3. 서브쿼리는 ?에 해당하는 것을 먼저 해결할때 사용한다.
4. 서브쿼리는 from절 뒤 | where절 뒤 | having절 뒤..이렇게 3가지 유형으로 나뉜다.
5. 단일행 서브쿼리 + 단일행 연산자    |    다중행 서브쿼리 + 다중행 연산자(IN, ANY) 
   스칼라 서브쿼리 - 1row + 1column
*/
-- CLARK의 급여보다 더 많은 급여를 받는 사원을 검색하세요...
SELECT sal FROM emp WHERE ename = 'CLARK';
SELECT ename, sal FROM emp WHERE sal > 2450;

SELECT ename, sal FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'CLARK');

-- 급여를 가장 많이 받는 사원 5명을 검색
SELECT * FROM emp ORDER BY sal DESC limit 5;

-- ename이 KING인 사원과 같은 부서에서 근무하는 사원을 검색
SELECT * FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename='KING');

-- 10번 부서에서 근무하는 사원중에서 사원전체의 평균 급여보다 더 많은 급여를 받는 사원을 검색
SELECT avg(sal) FROM emp; -- ?에 해당하는 쿼리
SELECT * FROM emp WHERE deptno=10 AND sal > (SELECT avg(sal) FROM emp);

-- job별 가장 적은 평균급여를 검색 ?에 해당...
SELECT job, avg(sal) FROM emp GROUP BY job; -- 이중에서 가장 적은 평균급여는 1037.5
SELECT job, min(avg(sal)) FROM emp GROUP BY job; -- MySQL에서는 그룹함수 중첩이 안된다...오라클 경우와 다르다.

SELECT job, avg(sal) FROM emp GROUP BY job 
HAVING AVG(sal)=(SELECT min(avg(sal)) FROM emp GROUP BY job); -- MySQL에서는 그룹함수 중첩이 안된다...오라클 경우와 다르다.

-- LIMIT 사용하자
SELECT job, avg(sal) asal FROM emp GROUP BY job ORDER BY asal limit 1;

-- SCOTT의 급여보다 더많은 급여를 받는 사원을 검색(테이블 알리야스를 사용하는 방법 추가)
-- 1) 
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');
-- 2) 
SELECT * FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal > b.sal;

-- 직속상관이 KING인 사원의 이름과 급여를 검색 (?에 해당하는 쿼리...자신의 MGR이 KING의 EMPNO
SELECT ename, sal FROM emp WHERE mgr = (SELECT empno FROM emp WHERE ename='KING');

-- JOB이 사원 7369번의 업무와 같고, 급여가 사원 7876번 보다 많은 사원을 검색
SELECT * FROM emp
WHERE job = (SELECT job FROM emp WHERE empno=7369)
AND sal > (SELECT sal FROM emp WHERE empno=7876);

-- 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색(?...는 20번 부서의 최소급여이다)
SELECT deptno, min(sal) FROM emp 
GROUP BY deptno
HAVING min(sal) > (SELECT min(sal) FROM emp WHERE deptno=20);

-- 부서별 최소급여와 같은 급여를 가지는 사원을 검색(?...에 해당하는 것은 부서별 최소급여)
SELECT empno, ename, sal FROM emp
WHERE sal = (SELECT min(sal) FROM emp GROUP BY deptno); -- X

SELECT min(sal) FROM emp GROUP BY deptno; -- 다중행 서브쿼리는 다중행연산자와 함께 사용

SELECT empno, ename, sal FROM emp
WHERE sal IN (SELECT min(sal) FROM emp GROUP BY deptno); -- 다중행 연산자 IN을 사용

-- 급여를 3000 이상 받는 사원이 소속된 부서와 동일한 부서에 근무하는 사원을 검색...?에 해당...(급여를 3000이상 받는 사원이 소속된 부서)
SELECT * FROM emp;

-- 서브 쿼리를 돌려보고 메인 쿼리를 돌리는 것이 좋다.
SELECT distinct deptno FROM emp WHERE sal >= 3000;

SELECT * FROM emp 
WHERE deptno IN (SELECT distinct deptno FROM emp WHERE sal >= 3000);

-- 다중행 연산자 
/*
IN - (A OR B OR C) 여러개 중에서 같은 값을 찾음 
ANY - 메인쿼리의 비교조건이 서브쿼리 검색결과와 하나이상만 일치하면 참이됨  
ALL - 메인쿼리의 비교조건이 서브쿼리 검색결과와 모든 값이 일치하면 참이됨

>ANY - 최소값 보다 많음
<ANY - 최대값 보다 작음
<ALL - 최소값 보다 작음 
>ALL - 최대값 보다 많음 
*/
-- < ANY 최대값 보다 작다
-- 급여가 어떤 점원(CLERK)보다도 작으면서 CLERK이 아닌 사원을 검색 
-- 1)
SELECT sal FROM emp WHERE job='CLERK'; -- 800, 1100, 950, 1300 (이중 하나만 일치)
-- 2)
SELECT * FROM emp 
WHERE sal < ANY (SELECT sal FROM emp WHERE job='CLERK')
AND job <> 'CLERK'; -- !=

-- >ALL 최대값보다 더 많은 급여
-- 급여가 모든 부서의 평균보다 많은 사원을 검색 (?에 해당하는...부서별 평균급여)
-- 1)
SELECT avg(sal) FROM emp GROUP BY deptno; -- 2175, 1566, 2916
-- 2)
SELECT * FROM emp WHERE sal > ALL (SELECT avg(sal) FROM emp GROUP BY deptno);

SELECT * FROM emp;
-- Q1
-- 급여가 10번부서에 속한 어떤 사원의 급여보다 더 많은 급여를 받는 사원을 검색. 이때 10번 부서에 속한 사원은 제외 
-- 정렬은 사원번호순으로 한다. 
SELECT sal FROM emp WHERE deptno=10; -- 10번 부서에 속한 어떤 사원의 급여 (2450, 5000, 1300)
SELECT * FROM emp 
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno=10) AND deptno <> 10 
ORDER BY empno;

-- Q2
-- 30번 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 검색 
-- 1)
SELECT max(sal) FROM emp WHERE deptno = 30; -- (2850) 30번 소속 사원들 중 가장 많이 받는 사원의 급여

-- 2) 위의 결과를 가지고 다시 디스플레이 해야한다. having절이 필요
SELECT deptno, max(sal) FROM emp GROUP BY deptno; -- 5000 | 3000 | 2850

SELECT deptno, max(sal) FROM emp 
GROUP BY deptno 
HAVING deptno=30;

SELECT ename, sal FROM emp 
WHERE sal > (SELECT max(sal) FROM emp 
GROUP BY deptno 
HAVING deptno=30);

SELECT ename, sal FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE deptno = 30);

-- 부하직원을 거느린 사원을 검색 (== empno가 mgr에 있는 사원)
-- 1)
SELECT distinct mgr FROM emp;
SELECT * FROM emp WHERE empno IN (SELECT distinct mgr FROM emp);

-- 2)
SELECT e.ename 상사이름, e.empno 상사의사원번호 FROM emp e 
WHERE e.empno IN (SELECT m.mgr FROM emp m);

-- 부하직원을 거느리지 않는 사원을 검색 (== empno가 mgr에 없는 사원, not in을 사용)
-- 1)
SELECT * FROM emp WHERE empno NOT IN (SELECT mgr FROM emp); -- 값이 안나옴..문제발생
SELECT * FROM emp WHERE empno=7902 OR empno=7698 OR empno=7839 OR empno=7566 OR empno=null;
SELECT * FROM emp WHERE empno!=7902 AND empno!=7698 AND empno!=7839 AND empno!=7566 AND empno!=null;
-- 2) 서브쿼리에서 null값 핸들링하는 문제가 가장 어려운 문제로 취급 
SELECT * FROM emp WHERE empno NOT IN (SELECT ifnull(mgr,0) FROM emp);
SELECT * FROM emp WHERE empno NOT IN (SELECT mgr FROM emp WHERE mgr is not null);

