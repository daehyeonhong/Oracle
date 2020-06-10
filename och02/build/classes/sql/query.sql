select job,salary,hiredate from EMPLOYEE where ename='SMITH';
select ename,job,salary,hiredate from EMPLOYEE where dno=10;
select*from dept;
select*from EMPLOYEE;

create table dept_test1 as select*from DEPARTMENT;

insert into dept_test1 values(50,'SALES','L.A',"");

update dept_test1 set loc ='DALLAS'where dno=60;

select*from dept_test1;
drop table dept_test1;
select*from user_triggers where table_name='DEPT';

--alter trigger [trigger_name] disable;
alter trigger trigger_sample1 disable;

select*from dept_test1 order by dno;
delete from dept_test1 where dno=60;

rename dept_test1 to dept
rename dept to dept5;

select*from dept where dno=10;
select*from dept where dno=20;
select dname from dept where dno=10;
select*from dept where dno=10;

select*from dept where dno=?;--10||20||30

select*from DEPT order by dno;

select*from employee;
insert into EMPLOYEE values(7799,'홍길동','CLERK',7788,sysdate,1500,null,20);


select eno,ename,job,salary,dname from EMPLOYEE a,DEPARTMENT b
where a.dno=b.dno and hiredate>'87/05/05' and a.dno=20 and job like 'CLERK';

select 