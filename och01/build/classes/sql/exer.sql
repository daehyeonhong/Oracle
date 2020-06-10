--ch02)
--ex01.
select ename,salary,salary+300
from EMPLOYEE;

--ex02.
select ename,salary,salary*12+100
from EMPLOYEE
order by salary*12+100 desc;

--ex03.
select ename,salary
from EMPLOYEE
where salary>2000
order by salary desc;

--ex04.
select ename,dno
from EMPLOYEE
where eno=7788;

--ex05.
select ename,salary
from EMPLOYEE
where salary not between 2000 and 3000;

--ex06.
select ename,job,hiredate
from EMPLOYEE
where hiredate between'81/02/20'and'81/05/01';

--ex07.
select ename,dno
from EMPLOYEE
where dno in(20,30)
order by ename desc;

--ex08.
select ename,salary,dno
from EMPLOYEE
where salary between 2000 and 3000
and dno in(20,30)
order by ename asc;

--ex09.
select ename,hiredate
from EMPLOYEE
where hiredate like'81%';