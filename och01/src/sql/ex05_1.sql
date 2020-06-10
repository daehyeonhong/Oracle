--그룹함수(집계함수)
--SUM()--합계
select sum(salary)from EMPLOYEE;

--AVG()--평균
select avg(salary)from EMPLOYEE;

--MAX()--최댓값
select max(salary)from EMPLOYEE;

--MIN()--최솟값
select min(salary)from EMPLOYEE;

--COUNT()--갯수
select count(eno)from EMPLOYEE;

--SUM(COLUMN)-집계 함수는 NULL을 제외하고 집계
select sum(commission)from EMPLOYEE;

--COUNT(COLUMN)-NULL은 제외하고 집계
select count(commission)from EMPLOYEE;

select sum(commission)/count(commission),avg(commission)from EMPLOYEE;

--COMMISSION/전체 사원의 수
select count(commission),count(eno),count(*),count(nvl(commission,0))from EMPLOYEE;

--중복을 제거한 칼럼 값의 집계 count(distinct column)
select count(job),count(distinct job)from EMPLOYEE;
select count(dno),count(distinct dno)from EMPLOYEE;
select count(manager),count(distinct manager)from EMPLOYEE;

--ORA-00937: not a single-group group function
select dno,count(distinct job)from EMPLOYEE;
--그룹별 집계 group by 기준칼럼,
select dno,count(distinct job)from EMPLOYEE group by dno;

--부서별 급여 합계 기준칼럼, sum()~~group by 기준칼럼;
select dno,sum(salary)from EMPLOYEE group by dno;

--부서별 사원 수 count(*)~~group by 기준칼럼;
select dno,count(*)from EMPLOYEE group by dno;
--부서별 최고급여max(),최소급여min()~~group by 기준 칼럼;
select dno,max(salary),min(salary)from EMPLOYEE group by dno;
select job,max(salary),min(salary)from EMPLOYEE group by job order by job;

-- 집계한 함수결과에 연산 가능
select max(salary)+1 from EMPLOYEE;

--집계기준이 두개 이상,먼저 기술한 칼럼순으로 기준
select dno,job, max(salary),min(salary),sum(salary),avg(salary)
			from EMPLOYEE
			group by dno,job--1.
order by dno,job;--2.

--
select dno,eno,salary from EMPLOYEE where salary>=1000;
--집계한 데이터 추출 조건 having조건
--select dno,sum(salary)from EMPLOYEE group by dno where sum(salary)>=1000;
select dno, sum(salary)from EMPLOYEE
			group by dno--1.그룹별 추출
having sum(salary)>=10000;--2.필터링

--부서 20의  직급별 급여를 얻고, 얻은 값이 3000 이상인 직급
select job,sum(salary)from EMPLOYEE
			where dno=20--1.개별데이터 추출
			group by job--2.추출한 개별데이터 그룹핑
having sum(salary)>=3000;--3.필터링

--20번 부서의 직급별 최고 급여를 구하고,최고 급여중에서 3000이상인 직급명과 급여출력
select job,max(salary)
			from EMPLOYEE
			where dno=20--1.개별데이터 조건
			group by job--2.그룹조건
having max(salary)>=3000;--3.필터링 조건

select job,max(salary) sum_sal--alias
			from EMPLOYEE
			where dno=20--1.개별데이터 조건
			group by job--2.그룹조건
having max(salary)>=3000;--3.필터링 조건--집계함수의 alias로 연산 불가.

--집계함수내 집계함수
select round(max(avg(salary)),2) from EMPLOYEE group by dno;

--ex1.
select 
			max(salary) maximum,
			min(salary) as minimum,
			sum(salary) sum,
			round(avg(salary),2) average
from EMPLOYEE;

--ex2.
select job,
			max(salary) maximum,
			min(salary) as minimum,
			sum(salary) sum,
			round(avg(salary),2) average
			from EMPLOYEE
group by job;

--ex3.
select job,count(*)from EMPLOYEE group by job;

--ex4.
select count(manager)from EMPLOYEE;

--ex5. 집계 후 연산 가능
select max(salary)-min(salary)from EMPLOYEE;

--ex6.
select job,min(salary)from EMPLOYEE group by job having not min(salary)<2000;

--ex7.
select dno,count(*),round(avg(salary),2)from EMPLOYEE group by dno;

--ex8.
select decode(dno,10,'acc',20,'rs',30,'sa',40,'op')dname,
			decode(dno,10,'NY',20,'DA',30,'CH',40	,'BO')loc,
			count(*),
			round(avg(salary))
			from EMPLOYEE
group by dno;

--ex9.
select job,dno,
			decode(dno,10,sum(salary))"부서10",
			decode(dno,20,sum(salary))"부서20",
			decode(dno,30,sum(salary))"부서30",
			sum(salary)"총액"
			from EMPLOYEE
			group by job,dno
order by dno;

--집계함수
--rollup(조건1,조건2)--조건1에 대한 소계, 조건2에 대한 소계,총계
select dno,job,sum(salary)from EMPLOYEE group by rollup(dno,job);

--가로합 세로로-pivot함수
select*from(select dno,job,salary from EMPLOYEE)
			pivot(
			sum(salary)for job in
			('CLERK'as"CLERK",
			'manager'as"MANAGER",
			'PRESIDENT'as"PRESIDENT",
			'ANALYST'as"ANALYST",
			'SALESMAN'as"SALESMAN"))
order by dno;