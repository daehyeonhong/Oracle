--DDL데이터 정의어
--create table table name(column type option);
create table dept(
dno number(2),
dname varchar(14),
loc varchar2(14)
);

select*from dept;

--서브쿼리를 이용한 테이블 생성
--create table table name as subquery;
create table dept3
as
select*from DEPARTMENT;
select*from dept3;

--서브쿼리 결과로 테이블 생성
create table dept4
as
select eno,ename,salary*12 annsal
from EMPLOYEE
where dno=20;

select*from dept4;

--must name this expression with a column alias
create table dept5 as select eno,ename,salary*12from EMPLOYEE where dno=20;--테이블 구조 복사

--테이블 구조 복사
create table dept_third as select dno,dname from DEPARTMENT where 1!=1;--false조건
celect *from dept_third

--employee 테이블 사원번호, 사원명,매니저명을 저장하는 테이블 emanager 테이블을 생성
create table emanager as select a.eno eno,a.ename ename,b.ename mname 
from EMPLOYEE a,EMPLOYEE b where a.manager=b.eno(+);

select*from emanager;
drop table emanager;
 
drop table dept7
 --테이블 구조 변경
 --alter table 테이블명[add|modify|drop]
 create table dept7 as select dno,dname from department;
 
 select b.loc from department a, dept7 b where a.dno=b.dno;
 truncate table dept7;
 insert into dept7 select*from department;
 --칼럼 loc추가
 alter table dept7 add (loc varchar2(14));
 update dept7 set loc= 
 select*from dept7;
 
 --칼럼 변경
 --alter table modify 칼럼(변경할 내용)
 alter table dept7 modify loc varchar2(20);
 select length(log)from dept7;
 

--ORA-01441: cannot decrease column length because some value is too big
 alter table dept7 modify loc varchar2(8);
 
 --칼럼 제거
 --alter table 테이블명 drop column
 alter table dept7 drop column loc;
 select*from dept7;
 
 --칼럼 사용불가 처리
 --alter table 테이블명 set unused(column)
 alter table dept7 set unused(loc);--loc칼럼 접근불가 처리
 
 alter table dept7 drop unused columns;-- 접근불가 처리된 칼럼 제거
 
 --칼럼명 변경
 --alter table 테이블명 rename column 칼럼명 to 바꿀칼럼명
alter table dept7 rename column loc to location;

--테이블 이름 변경
rename dept7 to dept77;
select*from dept77;
select*from dept7;

--테이블 삭제drop table 테이블명
drop table dept77;


create table parent
as select*from department;
select*from parent;

create table child
as select eno,ename,dno from employee;
select*from child;


--foreign key:부모 테이블의 primary키가 자식테이블의 속성으로 참조되는 키;
--parent, child 관계맺기
--ORA-02270: no matching unique or primary key for this column-list
alter table child
add constraint child_fk foreign key(dno)references parent(dno);

--parent table에 기본키 제약조건 추가
--add constraint 제약조건명 primary key(대상칼럼)
alter table parent add constraint parent_pk primary key(dno);
select*from parent;
select*from user_constraints where table_name='PARENT';
select*from user_constraints where table_name='CHILD';
select*from user_constraints where table_name in('PARENT','CHILD');

--부모 테이블 삭제
--ORA-02449: unique/primary keys in table referenced by foreign keys
--참조하는 테이블은 삭제 가능 참조받는 테이블 삭제 불가
drop table parent;--참조당하는 테이블(parent)삭제 불가
drop table child;--참조하는 테이블(child)삭제 가능

--foreign key관계 제거
--alter table 테이블명 drop constraint 제약조건명(child_fk)
alter table child drop constraint child_fk;

-- foreign key 제약조건 삭제 후 부모 테이블 삭제 가능
drop table parent;

--테이블 생성시 제약조건 추가
create table temp1(
dno number primary key,
dname varchar2(14)
);

create table temp2(
eno number primary key,
ename varchar2(20),
dno number,--칼럼 선언
foreign key(dno) references temp1(dno)--제약조건 추가
--foreign key(대상칼럼)references 부모 테이블(참조 칼럼)
);

select*from user_constraints where table_name in('TEMP1','TEMP2');

--데이터 자르기 truncate table 테이블명;
--truncate는 db에 바로 반영되는 삭제작업
--delete는 메모리에서 작업 후 commit;명령어에 의해 db에 반영,rollback;으로 되돌릴 수 있음.
select*from dept4;
truncate table dept4;
insert into dept4 select eno,ename,salary*12 anasal from employee;

--데이터 사전
--user_데이터 사전:접속한 user가 접속 가능한 정보
select table_name from user_tables;--hr유저가 만든 테이블리스트
select*from user_indexes;--hr유저의 생성된 index정보
select*from user_constraints;--hr유저의 제약 조건 정보
select*from user_objects;--hr유저의 생성된 객체 정보


--all_데이터 사전: 모든 유저가 접근 가능한 정보
select owner,table_name from all_tables order by owner,table_name;

--dba_데이터 사전: dba권한을 가진 유저 접근 가능한 정보(sys)
--ORA-00942: table or view does not exist
--sys as sysdba로 접속후
--grant dba to user;로 권한 부여.
--revoke dba from user;로 권한 회수
select owner,table_name from dba_tables;