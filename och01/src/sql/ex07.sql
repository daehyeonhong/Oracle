
select salary from EMPLOYEE where ename='SCOTT';
select ename,salary from EMPLOYEE where salary>3000;
select*from EMPLOYEE order by salary;

--sub query:다른 쿼리 안에 속한 쿼리문
select ename,salary from EMPLOYEE where salary>
(select salary from EMPLOYEE where ename='SCOTT');--한 건(행) 추출

select dname from DEPARTMENT where dno=20;
select dno from EMPLOYEE where lower(ename)='scott'

--sub-query:다중행 서브쿼리
--
select dname from DEPARTMENT
where dno= --한 건(행) 추출
(select dno from EMPLOYEE where lower(ename)='scott');--조회조건 먼저 실행되어 조회값 추출

--sub-query:다중행 서브쿼리
--ORA-01427: single-row subquery returns more than one row
select eno,ename,dno from EMPLOYEE where dno();
select dno from DEPARTMENT where dno<>10;

select eno,ename,dno from EMPLOYEE where dno in(
select dno from DEPARTMENT where dno<>10);

SELECT*
FROM EMPLOYEE
WHERE JOB
IN('MANAGER','SALESMAN')

--SUB QUERY
SELECT*
FROM EMPLOYEE
WHERE JOB
IN(SELECT JOB FROM EMPLOYEE WHERE JOB IN('MANAGER','SALESMAN'))

SELECT*FROM DEPARTMENT;
--'DALLAS'지역 부서에서 근무하는 사원업무(JOB)과 같은 업무를 가진 사원명,업무,부서번호
SELECT ENAME,JOB,SALARY,DNO
FROM EMPLOYEE
WHERE JOB 
IN(SELECT DISTINCT JOB
FROM EMPLOYEE
WHERE DNO=(
SELECT DNO
FROM DEPARTMENT
WHERE LOC='DALLAS'));

--부서별 최저급여를 받는 사원들 번호, 이름
--IN (값1,값2,값3,...)나열된 값 중에 만족하는 경우 추출
SELECT ENO,ENAME
FROM EMPLOYEE
WHERE SALARY IN(SELECT MIN(SALARY)FROM EMPLOYEEgroup by DNO);
--WHERE SALARY IN(950,800,1300);

-- 값들의 논리 합,나열된 기준에 하나라도 만족하면 
SELECT SALARY FROM EMPLOYEE WHERE JOB=UPPER('SALESMAN');

SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE SALARY<
ANY(
SELECT SALARY
FROM EMPLOYEE
WHERE JOB=UPPER('SALESMAN'));

SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE SALARY<ANY(1250,1250,1500,1600);

SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE SALARY<SOME(1250,1250,1500,1600);

SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE (SALARY<1250)OR(SALARY<1250)OR(SALARY<1500)OR(SALARY<1600);

--직책이 'SALESMAN'인 사원들 중 가장 적은 급여를 받는 사원보다 적은 급여를 받는 사원
--ALL(값1,값2,값3,...)-나열된 값 모두를 만족해야 추출
SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE SALARY<ALL(SELECT SALARY
								FROM EMPLOYEE
								WHERE JOB='SALESMAN');

--논리곱
SELECT ENO,ENAME,JOB,SALARY
FROM EMPLOYEE
WHERE (SALARY<1250)AND(SALARY<1500)AND(SALARY<1600);