SELECT * FROM emp; 
SELECT * FROM dept;
/*            [간단한 데이타 타입 정리] 
------------------- 정수 
   tinyint      아주 작은 범위의 정수		-128~127(0~155)
   smallint     작은 범위의 정수			-32768~32768(0~65535)
   int                               40억 (전세계 인구를 int로 할 수가 없다)
   decimal      고정소수                  전체자리수와 소수점 자리를 가진다.
                decimal(5,1)
------------------- 문자
   char(3)      고정형
   varchar(20)  문자수가 최대 n개인 문자열
   text         문자수가 최대 65535개인 문자열
------------------- 날짜
   date         년, 월, 일
   datetime     년, 월, 일, 시, 분, 초 
*/ 
-- [1. Projection | Selection ]
-- Projection : 컬럼명을 지정해서 데이타를 가져오는 쿼리문
SELECT * FROM emp; -- *을 사용하지 않는게 권장사항
SELECT empno, ename, job, deptno FROM emp;

-- emp 테이블에서 모든 사원의 이름과 입사일을 검색
SELECT ename, hiredate FROM emp;

-- emp 테이블에서 부서번호만 검색, 중복을 제외시키는 키워드..DISTINCT 사용...SELECT 바로 다음에 온다
SELECT deptno FROM emp;
SELECT DISTINCT deptno FROM emp;
SELECT DISTINCT(deptno) FROM emp; -- 정렬이 안되서 출력 --

-- 정렬은 오름차순(ASC, 기본) | 내림차순(DESC)
SELECT DISTINCT(deptno) FROM emp ORDER BY deptno ASC;
SELECT DISTINCT(deptno) FROM emp ORDER BY deptno;

-- 사원중에서 입사일이 가장 빠른 사원순으로 출력...(가장 빠른 사원이 가장 먼저 검색..)
SELECT ename, hiredate, job FROM emp ORDER BY hiredate;

-- 사원중에서 월급을 가장 많이 받는 사원순으로 검색되도록...
SELECT ename, job, sal FROM emp ORDER BY sal DESC;

SELECT ename, hiredate, job FROM emp ORDER BY hiredate DESC LIMIT 0,2;
SELECT ename, hiredate, job FROM emp ORDER BY hiredate DESC LIMIT 3;
/*
limit
::
출력하는 갯수를 제한
시작은 0부터 2개만 출력  limit 0,2
limit 3
*/
SELECT ename, job, sal FROM emp ORDER BY sal DESC LIMIT 1,2;

-- [1. Projection | Selection ]
-- Selection : 해당하는 조건을 만족하는 행을 검색
SELECT * FROM emp WHERE deptno=10;

-- emp 테이블에서 업무가 SALESMAN 인 사원의 이름, 급여, 연봉을 검색
SELECT ename, sal, sal*12+comm FROM emp WHERE job='SALESMAN';

-- Alias (별칭) 지정하는 방법 - 1) 컬럼명 as Alias, 2) 컬럼명 Alias, 3) 컬럼명 "Alias"
SELECT ename, sal, sal*12+comm AS AnnualSalary FROM emp WHERE job='SALESMAN';
SELECT ename, sal, sal*12+comm AnnualSalary FROM emp WHERE job='SALESMAN';
SELECT ename, sal, sal*12+comm "일년 총급여" FROM emp WHERE job='SALESMAN';

SELECT ename, sal, sal*12+comm AnnualSalary FROM emp WHERE job='SALESMAN' ORDER BY AnnualSalary DESC;

SELECT ename, sal, sal*12+comm "일년 총급여" 
FROM emp 
WHERE job='SALESMAN' 
ORDER BY sal*12+comm DESC;

-- emp 테이블에서 모든 사원의 이름, 급여, 연봉을 검색
SELECT ename, sal, sal*12+comm AnnualSalary
FROM emp
ORDER BY AnnualSalary; 
-- null값은 의미는 가지지만, 연산이 안된다.
-- 커미션이 null일때는 연산할 때 0으로 치환한다.

/*
ifnull(comm, 0)
:
comm이 null이면 0으로 
comm이 null이 아니면 comm으로
*/
SELECT ename, sal, sal*12+ifnull(comm,0) AnnualSalary
FROM emp
ORDER BY AnnualSalary;

-- comm이 null인 사원들의 이름, 업무, 급여, comm을 검색
SELECT ename, job, sal, comm
FROM emp
WHERE comm is null;

-- 상사번호(mgr)가 높은 순서대로.. null값은 제일 적은 값으로 출력된다. (Oracle과 반대)
SELECT DISTINCT mgr 상사번호
FROM emp
ORDER BY 상사번호 DESC;

/*
NULL 값에 대하여
::
1)자격없음
2)미확정
::
1) 사칙연산 적용 안됨....IFNULL()을 통해서 NULL값을 다른 값으로 치환해야한다.
2) 비교연산 적용안됨 .... is 혹은 is not
3) mysql에서는 가장 작은 값으로 지정 (oracle에서는 정반대임)
*/

-- [2. 함수 - 날짜관련 함수 - YEAR(날짜) | MONTH(날짜) ]
-- 사원중에서 81년도에 입사한 사원들의 정보를 디스플레이 
SELECT * FROM emp;
SELECT ename, hiredate, year(hiredate) 입사년도 FROM emp;

SELECT ename, hiredate, month(hiredate)
FROM emp
WHERE month(hiredate) = 5;

-- [3. LIKE 연산자와 와일드카드 %, _]
-- 사원의 이름중에서 A라는 이름이 들어가 있는 사원을 검색...LIKE연산자 + 와일드카드
SELECT ename, job, deptno
FROM emp
WHERE ename LIKE '%A%';

SELECT ename, job, deptno
FROM emp
WHERE ename LIKE '_A%'; -- _은 한글자만 매핑

-- 사원중에서 마지막 철자가 G로 끝나는 사원을 검색
SELECT ename, job, deptno
FROM emp
WHERE ename LIKE '%G'; 