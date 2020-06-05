-- 제약조건 constraint
-- 칼럼이나 테이블에 조건을 지정하여 부정확한 데이터 입력을 방지처리
-- not null 제약조건
create table customer2(
id varchar2(20)not null,
name varchar2(20)not null,
pwd varchar2(20)not null,
phone varchar2(20),
address varchar2(200)
);
select*from customer2;
-- 테이블 생성시 not null 제약조건으로 선언된 칼럼은 null이 될 수 없음
-- ORA-01400: cannot insert NULL into ("HR"."CUSTOMER2"."ID")
insert into customer2 values(null,null,null,'010-111-1234','서울시');
-- ORA-01400: cannot insert NULL into ("HR"."CUSTOMER2"."NAME")
insert into customer2 values('hong',null,null,'010-111-1234','서울시');
-- ORA-01400: cannot insert NULL into ("HR"."CUSTOMER2"."PWD")
insert into customer2 values('hong','홍길동',null,'010-111-1234','서울시');
-- not null 제약조건이 추가된 칼럼에는 반드시 값이 저장되어야 함.
insert into customer2 values('hong','홍길동','1234','010-111-1234','서울시');
-- not null 제약조건이 없는 칼럼은 비워두거나 null로 입력가능.
insert into customer2 values('kim','김길동','1234','010-111-1234','null');
select*from customer2;
commit

-- unique constraint(중복배제)
create table customer3(
id varchar2(20)unique,-- 중복배제 제약조건
name varchar2(20)not null,
pwd varchar2(20)not null,
phone varchar2(20),
address varchar2(200)
);

insert into customer3 values('hong','홍길동','1234',null,'서울시');
select*from customer3;
-- ORA-00001: unique constraint (HR.SYS_C007067) violated
insert into customer3 values('hong','김길동','1234',null,'서울시');

-- 제약조건 조회
-- unique 제약조건을 선언하면 해당 칼럼으로 index가 생성됨. 
select table_name,constraint_name,constraint_type
from user_constraints
where table_name in ('CUSTOMER3');

select table_name,constraint_name,constraint_type,index_name
from user_constraints
where table_name in ('CUSTOMER3');

select*from user_constraints
where table_name in ('CUSTOMER3');

create table customer4(
id varchar2(20)not null,
name varchar2(20)unique,-- 중복배제 제약조건
pwd varchar2(20)not null,
phone varchar2(20),
address varchar2(200)
);
-- unique constraint->name
insert into customer4 values('hong','홍길동','1234',null,null);
-- unique constraint->name
insert into customer4 values('hong','김길동','1234',null,null);
-- unique constraint->name
-- ORA-00001: unique constraint (HR.SYS_C007070) violated
insert into customer4 values('kim','홍길동','1234',null,null);
--unique 제약 조건은 not null 제약조건이 아니므로 null값 중복 입력됨.
insert into customer4 values('kim',null,'1234',null,null);

insert into customer4 values('kang',null,'1234',null,null);

select*from customer4;

--제약조건 이름 생성
--constraint 테이블명_칼럼명_제약조건타입
create table customer5(
id varchar2(20)constraint customer5_id_uq unique,
name varchar2(20)constraint customer5_pwd_nn not null,
pwd varchar2(20)constraint customer5_name_nn not null,
phone varchar2(20),
address varchar2(200)
);
-- 제약조건 조회
select table_name,constraint_name,constraint_type,index_name
from user_constraints
where table_name in ('CUSTOMER5');

--제약조건 조회
select table_name,constraint_name,constraint_type,index_name
from user_constraints
where table_name in ('CUSTOMER5','CUSTOMER3');

--primary key constraint
create table customer6(
id varchar2(20),
name varchar2(20)not null,
pwd varchar2(20)not null,
phone varchar2(20),
address varchar2(200),
constraint customer6_id_pk primary key(id)
);

--제약조건 조회
select table_name,constraint_name,constraint_type,index_name
from user_constraints
where table_name in ('CUSTOMER6');

-- priamary key 제약조건 =not null제약조건+unique 제약조건
-- ORA-01400: cannot insert NULL into ("HR"."CUSTOMER6"."ID")
insert into customer6 values(null,'홍길동','1234','','');

insert into customer6 values('hong','홍길동','1234','','');
-- ORA-00001: unique constraint (HR.CUSTOMER6_ID_PK) violated
insert into customer6 values('hong','김길동','3333','','');

select*from customer6;

--foreign key 제약조건: 부모 테이블의 기본키가 자식 테이블의 속성으로 참조되는 조건
select*from dept;
create table emp_f(
eno number(4) constraint emp_second_eno_pk primary key,
ename varchar2(10),
job varchar2(10),
dno number(9),
--constraint 제약조건명 foreign key(칼럼	) references 부모테이블(칼럼)
constraint emp_second_dno_fk foreign key(dno)references department(dno)
);


--참조하는 부모테이블의 칼럼의 값들(domian)내의 값만 입력,혹은 null값 입력
insert into emp_f values(7788,'홍길동','Manager',10);
insert into emp_f values(7789,'임꺽정','Clerk',null);--null 입력 가능
insert into emp_f values(7790,'일지매','Clerk',40);

-- 참조 무결성 제약조건 위배(부모 테이블에 해당 칼럼 값(50)이 존재하지 않음)
-- ORA-02291: integrity constraint (HR.EMP_SECOND_DNO_FK) violated - parent key not found
insert into emp_f values(7791,'이순신','Manager',50);

insert into department values(50,'OPERATAIONS','L.A');-- 부모 테이블에 50정보 등록 후 입력 가능.
insert into emp_f values(7791,'이순신','Manager',50);

select table_name,constraint_name,constraint_type,index_name
from user_constraints
where table_name in ('department','emp_f');
select*from emp_f;
select*from department;

-- check 제약조건: 값의 범위 지정, 지정된 범위의 값만 등록 되도록 제약.
create table emp_c(
eno number(4) constraint emp_c_eno_pk primary key,
ename varchar2(10),
-- 칼럼명 데이터 타입 constraint 제약조건명 check(조건)
salary number constraint emp_c_salary_min check(salary>0)
);

select*from emp_c;
insert into emp_c values(7788,'홍길동',1500);

-- ORA-02290: check constraint (HR.EMP_C_SALARY_MIN) violated
-- check 제약조건 범위를 벗어난 값 입력시 오류 및 입력 불가.
insert into emp_c values(7789,'임꺽정',-1500);

-- 제약조건 조회 SEARCH_CONDITION 칼럼
select*from user_constraints where table_name='EMP_C';

create table emp_c2(
eno number(4)constraint emp_c2_eno_pk primary key,
ename varchar2(10),
salary number default 1000
);
insert into emp_c2(eno,ename) values(7788,'홍길동');

select*from emp_c2;
-- 테이블 생성 후 제약 조건 추가
-- alter table 테이블명 add constraint 제약조건명 칼럼
drop table emp_copy;
create table emp_copy
as select*from employee
where 0=1;

select*from emp_copy;
-- alter table 테이블명 add constraint 제약조건명 primary key(칼럼)
alter table emp_copy add constraint emp_copy_pk primary key(eno);
select*from user_constraints where table_name='DEPT';
-- 참조되는 테이블(dept)의 기본키 생성 (index생성)
alter table dept add constraint dept_pk primary key(dno);
-- 참조하는 테이블(emp_copy)에서 참조되는 테이블(dept)관계 제약조건 추가
alter table emp_copy add constraint emp_copy_dno_fk foreign key(dno)references dept(dno);
-- 제약조건 조회
select*from user_constraints where table_name in('DEPT','EMP_COPY');

-- 제약조건 제거
-- alter table drop 제약조건명
alter table emp_copy drop primary key;

-- alter table 테이블명 disable|ename 제약 조건
select*from dept;
-- ORA-02292: intergrity constraint (HR.EMP_COPY_DNO_FK) violated
-- child record found
delete from dept where dno=10;
select constraint_name,constraint_type,table_name,status from user_constraints
where table_name in('EMP_COPY','DEPT');
-- 참조 제약조건 비활성화 alter table 테이블명 disable constraint 제약조건명;
alter table emp_copy disable constraint emp_copy_dno_fk;
-- 부모 테이블의 칼럼 삭제
delete from dept where dno=10;

-- 참조 제약조건 활성화 alter table 테이블명 disable constraint 제약조건명;
-- ORA-02298: cannot validate (HR.EMP_COPY_DNO_FK)
-- 비활성화 후 부모 테이블의 primary key인 dno 칼럼의 dno값이 변경, 10이 사라짐
alter table emp_copy enable constraint emp_copy_dno_fk;
select*from emp_copy;
select*from dept;

-- 사라진 dno 10값을 다시 입력 후
insert into dept select dno,dname,loc from department where dno=10;
-- 참조 제약조건 활성화 처리
alter table emp_copy enable constraint emp_copy_dno_fk;

--modify 칼럼 타입 길이 not null