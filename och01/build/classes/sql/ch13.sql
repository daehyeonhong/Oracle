-- 권한 부여
-- 객체 소유자가 객체 권한을 다른 유저에게 부여
SQL> show user
USER is ""
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> grant create session to usertest01;

Grant succeeded.


SQL> select eno,ename,hiredate from employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13

SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13

SQL> connect usertest01/pass1
Connected.
SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13
      
-- 권한 회수
      
      SQL> connect sys as sysdba
Enter password:
Connected.
SQL> show user
USER is "SYS"
SQL> revoke create session from usertest01;

Revoke succeeded.

SQL> connect usertest01/pass1
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.

-- with grant option 권한 부여

create user usertest02
identified by pass2
default tablespace users
temporary tablespace temp
quota unlimited on users;

grant create session, create table, create view to usertest02;

SQL> connect sys as sysdba
Enter password:
Connected.
SQL> create usertest02
  2  identified by pass2
  3  default tablespace users
  4  temporary tablespace temp
  5  quota unlimited on users;
create usertest02
       *
ERROR at line 1:
ORA-00901: invalid CREATE command


SQL> create user usertest02
  2  identified by pass2
  3  default tablespace users
  4  temporary tablespace temp
  5  quota unlimited on users;

User created.

SQL>
SQL> grant create session, create table,create view to usertest02;

Grant succeeded.

SQL> connect hr/hr
Connected.
SQL> grant select on employeee to usertest02 with grant option;
grant select on employeee to usertest02 with grant option
                *
ERROR at line 1:
ORA-00942: table or view does not exist


SQL> grant select on employee to usertest02 with grant option;

Grant succeeded.

SQL> grant select on hr.employee to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.
SQL> connect usertest02/pass2
Connected.
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> grant create session to usertest;
grant create session to usertest
                        *
ERROR at line 1:
ORA-01917: user or role 'USERTEST' does not exist


SQL> grant create session to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1;
Connected.
SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13

-- create role 롤 명
SQL> create role roletest01;

Role created.
-- grant 권한 to 롤 명
SQL> grant create session, create table,create view to roletest01;

Grant succeeded.
-- grant  롤명 to 유저.
SQL> grant roletest01 to usertest01;

Grant succeeded.

-- 롤 정보 조회
select*from role_sys_privs;				-- 롤에 부여된 시스템 권한
select*from role_tab_privs;				-- 롤에 부여된 테이블 관련 권한
select*from user_role_privs;				-- 접근가능 권한
select*from user_tab_privs_made;	-- 해당 사용자가 부여한 권한(table)
select*from user_tab_privs_recd;		-- 사용자에게 부여된 권한(table)
select*from user_col_privs_made;	-- 해당 사용자가 부여한 권한(column)
select*from user_col_privs_recd;		-- 해당 사용자가 부여한 권한(column)

-- 롤 삭제
SQL> drop role roletest01;

Role dropped.

-- synonym(동의어) - 객체 별칭 붙이기
create synonym hremp for employee;

select*from hremp;
select*from employee;

-- DBA 롤로 접속
SQL>show user;
user is "SYS"
--hr 유저의 employee 조회 가능 확인
conncect usertest01/pass1 connected;

-- 개인 synonym 생성
--create synonym 시노님명 for 유저. 오브젝트
connect usertest01/pass1;

-- sysnonym 생성 권한 부여 시노님명 for 유저.오브젝트
create public synonym hr_syn_emp for hr.employee;

-- 공용 시노님 명으로 조회
select count(*)from hr_syn_emp;
connect scott/tiger
select count(*)from hr_syn_emp;

-- 시노님 삭제
-- drop synonym 시노님명
drop synonym syn_hr_emp;