--EX1.사원번호가 7788인 사원의 담당업무와 업무가 같은 사원
SELECT JOB FROM EMPLOYEE
WHERE ENO=7788;
SELECT ENAME,JOB FROM EMPLOYEE
where JOB='ANALYST' AND ENO<>7788;

SELECT ENAME,JOB FROM EMPLOYEE
WHERE JOB=(SELECT JOB FROM EMPLOYEE WHERE ENO=7788)
AND ENO<>7788;

--EX2. 7499사원보다 급여가 많은 사원명,담당업무
SELECT ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE SALARY>(SELECT SALARY FROM EMPLOYEE WHERE ENO=7499);

--EX3.부서별 최소급여를 받는 사원 이름,담당업무,급여
SELECT MIN(SALARY)FROM EMPLOYEE group by DNO;
SELECT ENAME,JOB,SALARY FROM EMPLOYEE
WHERE SALARY IN(SELECT MIN(SALARY) FROM EMPLOYEE GROUP BY DNO);

--EX4. 직급별 평균급여가 가장 작은 사원의 담당업무를 찾아 직급과 평균급여 표시
SELECT AVG(SALARY)FROM EMPLOYEE;
SELECT DNO,AVG(SALARY)FROM EMPLOYEE GROUP BY DNO;
SELECT JOB,AVG(SALARY)FROM EMPLOYEE GROUP BY JOB;

SELECT MIN(AVGSAL)
FROM(SELECT JOB,AVG(SALARY)AVGSAL FROM EMPLOYEE GROUP BY JOB);

SELECT JOB,AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB
HAVING AVG(SALARY)=(SELECT MIN(AVGSAL)
FROM(SELECT JOB,AVG(SALARY)AVGSAL FROM EMPLOYEE GROUP BY JOB));

SELECT MIN(AVG(SALARY))
FROM(
SELECT JOB,AVG(SALARY)SALARY
FROM EMPLOYEE
GROUP BY JOB);

--EX5. 각 부서의 최소급여 직원명,급여,부서번호
SELECT ENAME,SALARY,DNO
FROM EMPLOYEE
WHERE SALARY
IN(
SELECT MIN(SALARY)
FROM EMPLOYEE
GROUP BY DNO);

--EX6. 'ANALYST'보다 급여가 적으면서 'ANALYST'가 아닌 사원 사번,이름,업무,급여
SELECT SALARY FROM EMPLOYEE WHERE UPPER(JOB)＝'ANALYST'

SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE SALARY< ALL(SELECT SALARY
							FROM EMPLOYEE
							WHERE UPPER(JOB)='ANALYST')
AND UPPER(JOB)<>'ANALYST';

SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE SALARY< (SELECT MIN(SALARY)
							FROM EMPLOYEE
							WHERE UPPER(JOB)='ANALYST')
AND UPPER(JOB)<>'ANALYST';

--EX7. 부하직원이 없는 사원 이름
--ex7-1. 상사가 없는 사원
select*from EMPLOYEE where manager is null;

SELECT distinct(MANAGER) FROM EMPLOYEE WHERE MANAGER IS NOT NULL order by manager;

select*from EMPLOYEE where eno not in(
SELECT distinct(MANAGER) FROM EMPLOYEE WHERE MANAGER IS NOT NULL);

--ex8. 부하직원이 있는 사원
select*from EMPLOYEE where eno in(
SELECT distinct(MANAGER) FROM EMPLOYEE WHERE MANAGER IS NOT NULL);

--ex9. blake와 동일한 부서에 속한 사원명, 입사일(blake 제외)
select dno from EMPLOYEE where ename like upper('blake');
select ename,hiredate from employee where dno=(select dno from EMPLOYEE where ename like upper('blake'))
and ename<>upper('blake');

select ename,hiredate from EMPLOYEE where dno=(select dno from EMPLOYEE where ename like upper('blake'))
and eno<>(select eno from employee where ename=upper('blake'));

--ex10. 급여가 평균급여보다 많은 사원
select avg(salary)from EMPLOYEE;
select eno,ename,salary
from EMPLOYEE
where salary>(select avg(salary)from EMPLOYEE)
order by salary;

--ex11. 'K'가 포함된 사원
select dno from EMPLOYEE where ename like '%K%';
select eno,ename from EMPLOYEE where dno in(select dno from EMPLOYEE where ename like '%K%');

--ex12. 부서 위치가 'DALLAS'인 사원명, 부서번호, 담당업무
SELECT dno from DEPARTMENT where loc=upper('dallas');
select ename,dno,job from EMPLOYEE where dno=(select dno from DEPARTMENT where loc=upper('dallas'));

--ex13. KING에게 보고하는 사원명,급여==상사가KING
select eno from EMPLOYEE where ename like upper('king');
select ename,salary from EMPLOYEE where manager=7839;

--서브쿼리로 작성
select ename,salary
from EMPLOYEE
where manager=(
select eno
from EMPLOYEE
where ename
like upper('king'));

--ex14. research부서의 부서번호,사원명,담당업무
select*from DEPARTMENT where dname=upper('research');

select*from DEPARTMENT where dno=20;
select dno,ename,job
from EMPLOYEE
where dno=(select dno from DEPARTMENT where dname=upper('research'));

--ex15. 평균급여보다 많은 급여를 받고 이름에 'M'이 포함된 사원과 같은 부서, 사원번호,이름
select avg(salary)from EMPLOYEE;
select distinct(dno) from EMPLOYEE where ename like'%M%';

select dno,eno,ename from EMPLOYEE where salary>(select avg(salary)from EMPLOYEE)
and dno in(select distinct dno from EMPLOYEE where ename like'%M%');

--ex16.

--ex17. 담당업무가 manager인 사원이 소속된 부서와 동일한 부서의 사원
select dno from EMPLOYEE where job='MANAGER';
select ename from EMPLOYEE where dno in(select dno from EMPLOYEE where job=upper('manager'));