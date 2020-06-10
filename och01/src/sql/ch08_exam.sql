--ex01.
select*from dept_test;
create table dept_test(
dno number(2),
dname varchar2(14),
loc varchar2(13)
);

--ex02.
select*from emp_test;
create table emp_test(
eno number(4),
ename varchar2(10),
dno number(2)
);

--ex03.
alter table emp_test modify ename varchar2(25);

--ex04.
select*from EMPLOYEE2;
create table EMPLOYEE2 (emd_id,name,sal,dept_id)
as select eno,ename,salary,dno from EMPLOYEE;

--ex05.
select*from emp_test;
drop table emp_test;

--ex06.
select*from emp_test;
rename employee2 to emp_test;

--ex07.
select*from dept_test;
alter table dept_test drop column dname;

--ex08.
alter table dept_test set unused column loc;

--ex09.
alter table dept_test drop unused columns;