--1.
select max(salary)"Maximum",
			min(salary)"Minimum",
			sum(salary)"Sum",
			round(avg(salary))"Average"
from EMPLOYEE;

--2.
select job"Job",max(salary)"Maximum",min(salary)"Minimum",sum(salary)"Sum",round(avg(salary))"Average"
from EMPLOYEE group by job;

--3
select job,count(*)from EMPLOYEE group by job;

--4
select count(manager)from EMPLOYEE;

--5
select max(salary)-min(salary)"DIFFERENCE"from EMPLOYEE;

--6.
select job,min(salary)from EMPLOYEE group by job
having not min(salary)<2000order by min(salary)desc;

--7.
select
			dno"DNO",
			count(*)"Number of People",
			round(avg(salary),2)"Salary"
			from EMPLOYEE
			group by dno
order by dno;

--8.
select*from DEPARTMENT;

select d.loc,count(*),round(avg(salary)) from EMPLOYEE e,DEPARTMENT d
where e.dno=d.dno group by d.loc;

--9.
select job,dno,sum(salary)from EMPLOYEE group by job,dno order by dno;

select job,dno,
decode(dno,10,sum(salary))"부서 10",
decode(dno,20,sum(salary))"부서 20",
decode(dno,30,sum(salary))"부서 30",
sum(salary)"총액"
from EMPLOYEE
group by job,dno;
order by dno;
