--1.
select ename,job from EMPLOYEE job;

select ename,job
from EMPLOYEE
where job=(select job
from EMPLOYEE
where eno=7788);

--2.
select ename,job from EMPLOYEE;

select ename,job
from EMPLOYEE
where salary>(
select salary
from EMPLOYEE
where eno=7499
);

--3.
select ename,job,salary
from EMPLOYEE
where salary=(
select min(salary)
from EMPLOYEE
);

--4.
select job, round(avg(salary))
from EMPLOYEE
group by job
having round(avg(salary))=(
select min(round(avg(salary)))
from EMPLOYEE
group by job
);

--5.
select ename,salary,dno
from EMPLOYEE
where salary in(
select min(salary)
from EMPLOYEE
group by job);

--6.
select eno,ename,job,salary
from EMPLOYEE
where salary<any(
select salaRy
from EMPLOYEE
where job='analyst')
and job<>'analyst';

select eno,ename,job,salary
from EMPLOYEE
where salary<any(
select salary
from EMPLOYEE
where job='ANALYST')
and job<>'ANALYST';

select ename
from EMPLOYEE a natural join EMPLOYEE b

