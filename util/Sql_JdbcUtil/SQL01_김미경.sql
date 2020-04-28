-- 1. 급여가 1500 이상인 직원들의이름, 급여, 부서번호를조회하시오.
SELECT ename, sal, deptno 
FROM emp
WHERE sal>=1500;

-- 2. 직원중에서연봉이 2000 이상인직원들의이름, 연봉을조회하시오.
SELECT ename, sal*12+ifnull(comm,0) 연봉
FROM emp
WHERE sal*12+ifnull(comm,0)>=2000;

-- 3. 직원중에서 comm이없는직원의이름과급여, 업무, comm를조회하시오.
SELECT ename, sal, job, comm
FROM emp
WHERE comm is null;

-- 4. 입사한지가장오래된직원순으로 5명을조회하시오.
SELECT ename, hiredate
FROM emp
ORDER BY hiredate LIMIT 5;

-- 5. 1981년에 입사한직원들중에서 급여가 1500 이상 2500 이하인직원들의이름, 급여, 부서번호,입사일을 조회하시오.
SELECT ename, sal, deptno, hiredate
FROM emp
WHERE year(hiredate)='1981' AND sal BETWEEN 1500 AND 2500;

-- 6. 이름이 A로시작하는 직원의이름, 급여, 입사일을 조회하시오.
SELECT ename, sal, hiredate
FROM emp
WHERE ename LIKE 'A%';

-- 7. 05월에 입사한직원의이름, 급여, 입사일을조회하시오
SELECT ename, sal, hiredate
FROM emp
WHERE month(hiredate)='5';

-- 8. 세번째이름에 A 가들어간직원의이름, 급여, 입사일을조회하시오.
SELECT ename, sal, hiredate
FROM emp
WHERE ename LIKE '__A%';

-- 9. 이름이 K로끝나는직원의이름, 급여, 입사일을조회하시오.
SELECT ename, sal, hiredate
FROM emp
WHERE ename LIKE '%K';

-- 10. 커미션을받는직원의이름, 커미션, 급여를조회하시오.
SELECT ename, comm, sal
FROM emp
WHERE comm is not null and comm != 0;