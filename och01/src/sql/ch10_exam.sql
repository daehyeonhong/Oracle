-- ex01. employee table 구조 복사 -> emp_sample 사원 테이블의 사원 번호 칼럼에 테이블 레벨로 primary key 제약조건 지정
-- my_emp_pk
drop table emp_sample;
create table emp_sample
as select*from EMPLOYEE;
-- 테이블명 변경 rename 이전 테이블명 to 새로운 테이블명

-- 제약조건 조회
select*from user_constraints where table_name='EMP_SAMPLE';

-- alter table 테이블명 add constraint 제약조건명 primary key(칼럼);
alter table emp_sample add constraint my_emp_pk primary key(eno);

-- ex02. dept_sample 생성하여 my_dept_pk로 지정
create table dept_sample
as
select*from dept;
select*from dept_sample;
alter table dept_sample add constraint my_dept_sample_pk primary key(dno);
alter table dept_sample rename constraint my_dept_pk to my_dept_sample_pk;
select*from user_constraints where table_name='DEPT_SAMPLE';

-- ex03.
select*from emp_sample;
select*from user_constraints where table_name='EMP_SAMPLE';
alter table emp_sample add constraint my_emp_dept_fk foreign key(dno)references dept(dno);

-- ex04. 사원 테이블의 커미션 칼럼 0보다 큰 값만 입력
select*from emp_sample;
update emp_sample set commission=nvl(commission,0);
alter table emp_sample add constraint emp_commission_min check(commission>=0);

select*from emp_insert;
select*from user_constraints where table_name='EMP_INSERT';
insert into emp_insert values('7788','김길동',1500,20,sysdate);
-- primary key:unique and not null
-- ORA-02437: cannot validate (HR.EMP_INSERT_PK) - primary key violated(0 rows affected)
update EMP_INSERT set emp_id=(select max(emp_id)+1 from emp_insert)
where emp_id=7788
and rownum=1;--가상 칼럼(pseudo)

select rownum, emp_id from EMP_INSERT where emp_id=7788;

-- 중복값 제거 후 primary key 제약조건 추가
alter table emp_insert add constraint emp_insert_pk primary key(emp_id);

-- primary key 칼럼 두개 이상 설정 가능
create table emp_pr(
eno number not null,
ename varchar2(10),
sal number,
dno number
);
-- 두개 이상의 칼럼으로 primary key 생성 -복합키
alter table emp_pr add constraint my_emp_pr_pk primary key(eno,ename);
-- 칼럼이 두개 이상 복합으로 키가 생성되면 두 칼럼의 값으로 비교해서 키 중복 여부 확인
insert into emp_pr values(7788,'홍길동',1500,10);
insert into emp_pr values(7788,'일지매',1500,10);
select*from emp_pr;
-- ORA-00001: unique constraint (HR.MY_EMP_PR_PK) violated
insert into emp_pr values(7788,'홍길동',1500,10);
select*from user_constraints where table_name='EMP_PR';

--
-- ex05. 

select*from emp_sample;