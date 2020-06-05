--데이터 처리문 DML(Data Manipulation Language)-데이터 관점
--데이터 입력
--insert into table명(column1,column2,column3,...)values(값1,값2,값3,...);
create table dept_copy
as
select*from DEPARTMENT where 1=0;--false 조건
select*from dept_copy;

--data입력
insert into dept_copy(dno,dname,loc)
values(10,'accounting','New York');
--칼럼리스트 순서에 따라 값 순서대로 매칭되어 입력
insert into dept_copy(dname,dno,loc)
values('research',20,'Dallas');
--칼럼전체에 맞게 값 입력시는 칼럼리스트 생략 가능
insert into dept_copy values(30,'sales','L.A');

--빈값(null)을 가진 데이터 입력
--ORA-00947: not enough values
insert into dept_copy values(40,'operation');
--테이블 전체 칼럼 갯수보다 적은 값 입력시 나머지는 null로 채움
insert into dept_copy values(40,'operation',null);
--null이 포함된 값 입력시 칼럼 리스트를 표기하고 표기한 갯수 만큼만 입력
insert into dept_copy(dno,dname)values(50,'manager');

--날짜 데이터 입력시 날짜 포맷'yy/mm/dd'로 입력하거나 to_date('날짜문자열')
--현재날짜인 경우 sysdate로 대체
create table emp_copy
as
select*from EMPLOYEE where 1=0;--false조건

insert into emp_copy values(7000,'candy','manager',7788,'2012/05/01',3000,0,10);
select*from emp_copy;

--to_date('날짜문자열')
insert into emp_copy
values(7001,'choco','clerk',7788,to_date('2012/0501'),3000,0,10);

insert into emp_copy
values(7002,'jelly','manager',7788,trunc(sysdate,'dd'),3000,0,10);

insert into emp_copy
values(7002,'cookie','sales',7788,sysdate,3000,0,10);

--sub쿼리를 이용한 데이터 입력
--insert into 테이블명 subQuery;(values대신)
insert into emp_copy
select*from EMPLOYEE;

--테이블 생성시 칼럼 옵션 추가 default값을 선언
create table  bb(seq number primary key,--기본키 설정
title varchar2(100) not null,--null방지 설정
content varchar2(4000),--옵션 없음
readcnt number default 0,--값 미입력시 0으로 대체하여 입력
regdate date default sysdate);--값 미입력시 현재 날짜를 대체하여 입력

select*from bb;
insert into bb(seq,title,content)values(1,'제목1','내용1');
insert into bb(seq,title,content,readcnt)values(2,'제목2','내용2',3);
insert into bb(seq,title,content,regdate)values(3,'제목3','내용3','2012/05/05');
insert into bb(seq,title,content,readcnt,regdate)values(4,'제목4','내용4',5,'2012/05/05');

--테이블 내에서 최대 순번+1을 새로운 순번으로 추출
select nvl(max(seq),0)+1 seq from bb;

--입력된 데이터 수정
--update table 테이블명 set 칼럼1=값1,칼럼2=값2,...where 조건
select*from bb;
update bb set title='타이틀2' where seq=2;
--n*n
update bb set title='타이틀4',readcnt=5,regdate=sysdate where seq=4;

update bb 
set title='타이틀5',
readcnt=(select nvl(readcnt,0)+1 from bb where seq=5),
regdate=sysdate
where seq=5;

update bb
set title='타이틀5',
readcnt=readcnt+1,--칼럼의 현재 값 + 1한 결과를 다시 readcnt칼럼에 저장
regdate=sysdate
where seq=5;

-- 테이블 칼럼 추가
alter table bb add good number default 0;
alter table bb add bad number default 0;
--숫자 칼럼의 값 증가 처리 칼럼= 칼럼+증가치
update bb set good=good+1 where seq=1;
update bb set bad=bad+1 where seq=3;



select*from bb;

--칼럼 update 다른 테이블 값으로 update
update dept_copy set dname=(select dname from DEPARTMENT where dno=40),--서브쿼리(인라인뷰)
loc=(select loc from DEPARTMENT where dno=40)--서브쿼리(인라인뷰)
where dno=50;
select*from dept_copy;

--데이터 삭제
--delete from 테이블명 where 조건
delete from dept_copy where dno=30;

commit
select*from dept_copy;

select dno from department where dname='RESEARCH';
select*from department;
--단일행 서브쿼리
delete dept_copy where dno=(select dno from department where dname='RESEARCH');
--다중행 서브쿼리
delete dept_copy where dno in(select dno from department);
--이전 상태로 되돌리기
rollback

--commit:테이블에 저장된 데이터 변화가 발생한 정보를 db에 저장하는 명령어
--rollback:commit 이후 rollback명령어 실행시점까지의 변화된 정보를 commit시점까지 되돌리는 명령어.

create table stock(
item varchar2(30) primary key,
qty number default 0
);

create table bucket(
item varchar2(30) primary key,
qty number default 0
);

create table sale(
seq number primary key,
id varchar2(30),
item varchar2(30),
qty number default 0,
sdate date default sysdate
);


--재고 등록
insert into stock values('apple',10);
commit

--장바구니 등록
insert into bucket values('apple',3);
select*from bucket;
--장바구니 수량 변경
update bucket set qty=4 where item='apple';
--구매처리
insert into sale values(2,'hong','apple',
(select qty from bucket where item='apple'),sysdate);
select*from sale;
--장바구니 비우기
delete from bucket;
--재고 변경 처리
update stock set qty=qty-(select qty from bucket where item='apple')
where item='apple';
select*from stock;
rollback
select*from bucket;
select*from sale;
commit
truncate table stock;
truncate table bucket;
truncate table sale;
insert into stock values('mango',20);
insert into stock values('감자',20);
insert into stock values('구마',20);

select count('mango') from stock;
select count(*) from stock where item='구마';






--commit;-insert,update,delete같은 일련의 작업 내용을 DB에 영구 저장 명령어
--rollback;-insert,update,delete같은 일련의 작업 내용을 commit상태로 모두 되돌리는 명령어

commit
select*from bucket;--select는 트랜잭션 작업이 아니다.
select*from stock;
insert into bucket values('apple',5);--입력 작업
insert into stock values(5,'bababa',10);--입력 작업
commit
select*from bucket;
select*from stock;
commit--db에 저장된 시점
update bucket set qty=3 where item='apple';--select는 트랜잭션 작업이 아님
update stock set qty=qty-(select qty from bucket where item='apple')where item='apple';--select는 트랜잭션 작업이 아님
select*from bucket;
select*from stock;
rollback--이전상태(바로 앞의 commit 상태로 되돌리기)
select*from bucket;
select*from stock;
select*from sale;
delete sale;
delete bucket;
delete stock;
commit



--savepoint :트랜잭션 작업 기간을 세분화해서 처리
drop table dept;--commit 명령 없이 바로 DB에 반영
create table dept as select*from department;--commit 명령 없이 바로 DB에 반영
select*from dept;
delete from dept where dno=40;
commit--db에 반영
select*from dept;
delete from dept where dno=30;
savepoint s1;--savepoint 지정 savepoint 세이브포인트명
delete from dept where dno=20;
select*from dept;
savepoint s2;--savepoint 세이브포인트명
delete from dept where dno=10;
select*from dept;
rollback to s2;--savapoint s2 지점으로 데이터 되돌림.
select*from dept;
rollback to s1;--savepoint s1까지 되돌리기
select*from dept;
rollback;--commit한 지점까지 되돌리기

--commit한 지점으로 데이터 되돌림.

--create,alter,drop명령어는 commit 명령 없이 바로 DB에 반영



-- commit/rollback/savepoint
select*from dept;
delete from dept where dno=40;
select*from dept;
rollback
select*from dept;

commit
-- savepoint
alter table emp_copy disable constraint emp_copy_dno_fk;
alter table emp_sample disable constraint my_emp_dept_fk;
select*from dept;
delete from dept where dno=40;
savepoint s1;
delete from dept where dno=30;
savepoint s2;
delete from dept where dno=20;
select*from dept;
rollback to s1
rollback
select*from user_constraints;

create table test_save(
dno number primary key,
dname varchar2(20),
loc varchar2(20)
);
select*from test_save;
insert into test_save select*from department;
commit
select*from test_save;

