--ex01. dept 테이블 생성
--ORA-00955: name is already used by an existing object
create table dept_t(
dno number(2),
dname varchar2(14),
loc varchar2(13)
);

--ex2. emp table
create table emp_t(
eno number(4),
ename varchar2(10),
dno number(2)
);

--ex3. 칼럼 변경
alter table emp_t modify ename varchar2(25);

--ex4.
select eno emp_id, ename name, salary sal, dno dept_id from EMPLOYEE;
create table employee2 as select eno emp_id, ename name, salary sal, dno dept_id from EMPLOYEE;
select*from employee2;

--ex5. emp table 삭제
drop table emp_t;

--ex6. employee2 -> emp
rename employee2 to emp;
select*from emp;

--ex7. dept dname제거
select*from dept;
alter table dept drop column dname;

--ex8. loc칼럼 unused로 표시
alter table dept set unused(loc);

--ex9. unused 삭제
alter table dept drop unused columns;