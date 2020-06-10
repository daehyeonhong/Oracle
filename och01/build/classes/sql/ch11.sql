-- view
-- 테이블의 쿼리를 대신하는 용도의 객체
-- 보안성/편리성
-- 보안성: 외부에 노출을 꺼리는 민감한 정보는 쿼리문에서 제외하고
-- 일반적인 정보만 조회할 수 있도록 view 생성
create or replace view emp_view
as
select eno,ename,job,dno from EMPLOYEE;
select*from emp_view;
-- user가 emp_view를 조회하면 이때, 실제 테이블에서 view를 생성할 때 사용한 쿼리문 실행, 결과를 리턴해줌.
-- view는 데이터를 저장하지 않음
select*from user_views;
-- 사용자가 생성한 view 정보 user_views;
select view_name,text from user_views;

-- 편리성: 복잡한 쿼리문 view로 생성하여 필요시 실행
create or replace view v_emp_comp2
as select e.eno,e.ename,e.salary,dno,d.dname,d.loc
from EMPLOYEE e natural join dept d;

-- 자주 사용하는 복잡한 쿼리문 view로 생성 후 select*from view명. view 생성시 만든 쿼리문을 실행하여 결과를 리턴해줌.
select*from v_emp_comp2;

-- view 생성시 그룹함수 사용(별칭 사용)
create or replace view v_emp_salary
as select dno,sum(salary)as"sal_sum",round(avg(salary),2)as"sal_avg"
from EMPLOYEE group by dno;

select*from v_emp_salary;

-- view 삭제
create or replace view v_emp_job as select distinct job from EMPLOYEE;
-- ORA-00942: table or view does not exist
select*from v_emp_job;
-- view 삭제
drop view v_emp_job;

--
create or replace view v_dept
as
select*from dept;
select*from v_dept;

-- create or replace 조건에 의해 view가 없으면 create 생성
-- 기존에 동일한 이름의 view가 존재하면 replace로 재생성
create or replace view v_dept
as
select*from dept;

-- ORA-00955: name is already used by an existing object
create view v_dept
as
select*from dept;

create or replace view v_dept
as select*from dept;

select*from v_dept;
-- 단순 뷰(테이블과 view가 1:1인 뷰)에서는 insert/update/delete가 가능
-- 실무에서는 사용하지 않음.
insert into v_dept values(40,'OPERATIONS','L.A');

-- force옵션 테이블 상관 없이 강제로 view 생성
-- ORA-00955: name is already used by an existing object
create or replace force view v_emp_notable
as
select eno,ename,dno,job
from emp_ntable
where job like'MANAGER';

select*from like'MANAGER';

-- with check option
create table emp_second
as select eno,ename,dno,job
from employee;

create or replace view v_emp_job_jochk
as select eno,ename,dno,job from emp_second where job like 'MANAGER';

select*from v_emp_job_jochk;
insert into v_emp_job_jochk values(9000,'홍길동',30,'SALESMAN');

select*from emp_second;

-- with check option view 생성
create or replace view v_emp_job_chk
as
select eno,ename,dno,job
from emp_second
where job like'MANAGER'with check option;

select*from v_emp_job_chk;
-- ORA-01402: view WITH CHECK OPTION where-clause violation
insert into v_emp_job_chk values(9999,'홍길동',30,'SALESMAN');
insert into v_emp_job_chk values(9999,'홍길동',30,'MANAGER');

-- with read only 옵션
create or replace view v_emp_job_readonly
as
select eno,ename,dno,job
from emp_second
where job like 'MANAGER' with read only--읽기 전용 옵션
;
-- 삽입,수정,삭제 불가 with read only view.
select*from v_emp_job_readonly;
-- ORA-42399: cannot perform a DML operation on a read-only view
insert into v_emp_job_readonly values(9001,'일지매',20,'MANAGER');

-- view 생성
select*from employee;
select eno,ename,job,manager,dno from employee;
create or replace view v_emp2
as
select eno,ename,job,manager,dno from employee;
select*from v_emp2;

-- 복합 view
create or replace view v_emp_dname
as
select eno,ename,job,dname
from employee natural join department;

select*from v_emp_dname order by eno;