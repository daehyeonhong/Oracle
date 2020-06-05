--ex01.
select*from EMP_INSERT_TEST;
select*from emp;
create table emp_insert_test as select*from emp where 1=0;

--ex02.
select*from EMP_INSERT_TEST;
alter table emp_insert_test add(hiredate date);
insert into EMP_INSERT_TEST values(1,'gamja',1,1,sysdate);

--ex03.
insert into EMP_INSERT_TEST values(2,'goguma',1,1,to_date(sysdate-1));

--ex04.
select*from EMP_COPY_test;
create table emp_copy_test as select*from EMPLOYEE;

--ex05.
select*from emp_copy_test where eno=7788;
update EMP_COPY_TEST set dno=10 where eno=7788;

--ex06.
select*from emp_copy_test where eno in(7788,7499);
update EMP_COPY_TEST
set (job,salary)=(
select job,salary
from emp_COPY_TEST
where eno=7499)
where eno=7788;

--ex07.
select*from emp_copy_test where job=(
select job from emp_copy_test where eno=7369);
select*from emp_copy_test where eno=7369;

update emp_copy_test
set(dno)=(
select dno
from emp_copy_test
where eno=7369)
where job=(
select job
from emp_copy_test
where eno=7369);

--ex08.
select*from dept_copy_test;
create table dept_copy_test as select*from department;

--ex09.
select*from dept_copy_test;
delete from dept_copy_test where dname ='RESEARCH';
commit

--ex10.
delete from dept_copy_test where dno in(10,40);