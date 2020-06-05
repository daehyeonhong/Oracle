-- ex01. 사원테이블,사원번호 자동생성 되도록 시퀀스 생성
select*from EMPLOYEE order by eno;
create sequence emp_seq
start with 7935
increment by 1
maxvalue 100000;
select emp_seq.nextval from dual;

-- ex02. 사원번호 발급 받기
create table emp01 as select eno empno,ename,hiredate
from EMPLOYEE
where 1<>1;

insert into emp01 values(emp_seq.nextval,'홍길동',sysdate);
select*from emp01;

-- ex03. idx_emp01_ename
create index idx_emp01_ename
on emp01(ename);

insert into emp01 select eno,ename,hiredate from EMPLOYEE;
commit
select*from emp01 order by empno desc;

-- 인덱스 삭제
drop index idx_emp01_ename;

explain plan for select*from emp01 where empno =7788;

explain plan for select*from emp01 where ename ='SCOTT';

select*from table(dbms_xplan.display);