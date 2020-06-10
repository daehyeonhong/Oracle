-- ex01.
drop sequence emp_test_seq;
create sequence emp_test_seq
start with 1
increment by 1
maxvalue 5;
select emp_test_seq.nextval from dual;

-- ex02.
drop table emp_test;
select*from emp_test;
create table emp_test as select eno empno,ename,hiredate from EMPLOYEE where 1<>1;

insert into emp_test values(emp_test_seq.currval,'JULIA',sysdate);

-- ex03.
drop index idx_emp01_ename;
create index idx_emp01_ename on emp_test(ename);