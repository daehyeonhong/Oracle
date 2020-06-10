--1.
select job from EMPLOYEE where eno=7788;

select ename,job from EMPLOYEE where job=(select job from EMPLOYEE where eno=7788);

--2.
select salary from EMPLOYEE where eno=7499;

select ename,job from EMPLOYEE where salary>(select salary from EMPLOYEE where eno=7499);

--3.
select min(salary) from EMPLOYEE;

select ename, job,salary from EMPLOYEE where salary=(select min(salary)from EMPLOYEE);

--4.
select min(round(avg(salary),1))from EMPLOYEE group by job;

select job,round(avg(salary),1)from EMPLOYEE group by job 
having round(avg(salary),1)=(select min(round(avg(salary),1))
from EMPLOYEE group by job);

--5.
select min(salary) from EMPLOYEE group by job;

select ename,salary,dno from EMPLOYEE where salary in(select min(salary)from EMPLOYEE group by dno);

--6.
select min(salary)from EMPLOYEE where lower(job)='analyst';

select eno,ename,job,salary from EMPLOYEE where salary<
(select min(salary)from EMPLOYEE where lower(job)='analyst')
and lower(job)<>'analyst';

--7.
select  b.ename"상사이름",a.ename"부하"
from EMPLOYEE a, EMPLOYEE b where a.manager(+)=b.eno;

select ename from  b.ename"상사이름",a.ename"부하" where a.ename=(
select  b.ename"상사이름",a.ename"부하"
from EMPLOYEE a, EMPLOYEE b where a.manager(+)=b.eno);