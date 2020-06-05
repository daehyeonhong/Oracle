-- 프로시져 -명령문을 모아서 하나의 그룹으로 처리하기 위한 객체
-- create or replace procedure [procedure_name] is 변수 begin~~end;
create or replace procedure sp_salary
is
v_salary employee.ename%type;
begin
	select salary into v_salary from employee where ename='SCOTT';
	DBMS_output.put_line('SCOTT의 급여는 '||V_SALARY);
end;

-- user_source에 객체로 저장
select name, text from user_source where name='SP_SALARY';

-- 실행 --command|sqlplus에서 실행
execute sp_salary;


-- 삭제
-- drop procedure [procedure_name];
drop procedure sp_salary;

-- 매개변수(argument)를 받는 procedure
create or replace procedure sp_salary_ename(v_ename in employee.ename%type-- argument 선언 값을 읽어들이는 모드
)
is
v_salary employee.salary%type; -- 변수선언
begin
	select salary into v_salary from employee where ename=v_ename;
	dbms_output.put_line(v_ename||'의 급여는 '||v_salary);
end;
-- procedure 소스 확인
select name,text from user_source where name='SP_SALARY_ENAME';
-- procedure 상태 확인 status_valid
select object_name,object_type,status from user_objects where object_name='SP_SALARY_ENAME';

-- out 매개변수
create or replace procedure sp_salary_ename2(
v_ename in employee.ename%type,
v_salary out employee.salary%type
)
as
begin
	select salary into v_salary from employee where ename=v_ename;
end;
select status from user_object where object_name='SP_SALARY_ENAME2'


--실행
--out모드의 변수 값 받기 위한 변수 선언
-- variable 변수명 타입;
variable v_salary varchar2(14);
--실행
--execute procedure_name(입력값, :출력변수)
execute sp_salary_ename2('SCOTT',:V_SALARY);
--변수값 console에 출력
--print 변수
print v_salary;

-- procedure
--전사원의 급여를 5%인상 후 전체 급여액 출력
create or replace procedure pr_emp_upSal
(tot out number)--출력용 매개변수 선언
as
begin
		-- 급여인상 처리
		update employee
		set salary = salary+salary*0.05;-- 전사원
		commit;--트랜잭션 처리 후 DB 반영처리
		select sum(salary)
		into tot
		from employee;
end;

-- 출려용 매개변수 값을 받는 선언 variable 변수명 타입
variable v_tot number(14);
-- 실행 execute [procedure_name] (:변수명);
execute pr_emp_upSal(:v_tot);
-- 결과 출력 print 변수명;
print v_tot;

select sum(salary+salary*0.05) from employee;


--함수
--function 실행문을 처리 후 결과를 리턴하는 형식의 객체

create or replace function fn_salary_ename(
v_ename in employee.ename%type
)
return number-- 리턴타입 선언
is
v_salary number(7,2);--소수점2, 정수4자리
begin
	select salary into v_salary from employee where ename=v_ename;
	return v_salary; --결과 값 리턴
end;

-- FUNCTION 정보 조회
select object_name,status from user_objects where object_type='FUNCTION';

-- 실행
-- 출력용 변수 선언
SQL> variable v_salary number;
-- 실행
-- execute :변수:=함수명
execute :v_salary:=fn_salary_ename('SCOTT');
-- 결과 출력
-- print 변수명;
print v_salary;
select ename,fn_salary_ename(ename)from employee order by eno;

-- 특정 사원의 입사일자를 구하는 함수
create or replace function fn_hire_eno(v_eno in employee.eno%type)
return date
as
v_hiredate date;
begin
	select hiredate into v_hiredate from employee where eno=v_eno;
	return v_hiredate;
end;
select object_name,status from user_objects where object_type='FUNCTION';





-- create or replace function 함수명(매개변수 타입)return 리턴타입 as begin~~end;
-- as begin~~return 결과; end;
create or replace function fn_hire_eno_t(v_eno number)
return date
as
v_date date;
begin
	select hiredate
	into v_date
	from employee
	where eno=v_eno;
	return v_date;
end;

create or replace function fn_hire_eno_t(v_eno number)--매개변수 선언
return varchar2--결과처리 리턴타입 지정
as
v_date date;
begin
	select hiredate
	into v_date
	from employee
	where eno=v_eno;
	return to_char(v_date);--결과 리턴문;
end;

--실행
--변수 선언
variable v_hiredate varchar2(20);
--실행 및 결과 얻기
execute :v_hiredate:=fn_hire_eno(7788);
--결과 출력
print v_hiredate;
--쿼리문에서 결과 출력
select eno,fn_hire_eno(eno)from employee where eno=7788;

--트리거
--테이블의 데이터 트랜잭션 발생 시 자동 처리해주는 객체 TRIGGER
CREATE OR REPLACE TRIGGER TRIGGER_SAMPLE1
AFTER INSERT-- 입력 직후 자동 실행되는 트리거
ON DEPT-- 등록될 테이블
FOR EACH ROW--행단위 실행
BEGIN
	IF INSERTING THEN--UPDATING,DELETING
	DBMS_OUTPUT.PUT_LINE('INSERT TRIGGER 발생');
	INSERT INTO DEPT_HISTORY
	VALUE(:NEW.DNO;:NEW.DNAME;:NEW.LOC,SYSDATE);--:NEW.칼럼,:OLD.칼럼
	-- 입력전 : NEW.DNO값은 NULL, :OLD.DNO의 갓 NULL
	-- 입력후 : NEW.DNO의 값은 입력값 :OLD.DNO의 값 NULL;
	END IF;
END;

-- 테이블 생성
DROP TABLE DEPT_HISTORY;
SELECT*FROM DEPARTMENT;
CREATE TABLE DEPT_HISTORY AS SELECT DNO,DNAME,LOC FROM DEPARTMENT WHERE 1<>1;
SELECT*FROM DEPT_HISTORY;

SELECT*FROM USER_TRIGGERS;
SELECT OBJECT_NAME,STATUS FROM USER_OBJECTS
WHERE OBJECT_TYPE='TRIGGER';

SELECT*FROM DEPT;
SELECT*FROM DEPT_HISTORY;


--삭제 트리거
CREATE OR REPLACE TRIGGER TRIGGER_DEL
AFTER DELETE --삭제 직후 실행되는 트리거
ON DEPT_ORG --
FOR EACH ROW --행단위 처리
BEGIN
	DBMS_OUTPUT.PUT_LINE('DELETING TRIGGER 발생');
	DELETE FROM DEPT_COPY WHERE DEPT_COPY.DNO:=OLD.DNO; -- 삭제 직후 이전 값으로 조회하여 삭제
	INSERT INTO DEPT_HISTORY VALUES(:OLD.DNO,:OLD.DNAME); --삭제 직후 이전 값으로 입력처리
	--삭제 전:OLD.DNO값 40, :NEW.DNO값 NULL;
	--삭제 후:OLD.DNO값 40, :NEW.DNO값 NULL;
END;
--DEPT_ORG TABLE 생성
CREATE TABLE DEPT_ORG AS SELECT*FROM DEPT;
CREATE TABLE DEPT_COPY AS SELECT*FROM DEPT_ORG;
--DEPT_COPY TABLE 생성
SELECT*FROM DEPT_ORG;

--UPDATE 트리거

CREATE OR REPLACE TRIGGER TRIG_UPDATE
AFTER UPDATE
ON DEPT
FOR EACH ROW
BEGIN
	DBMS_OUTPUT.PUT_LINE('UPDATE 트리거 발생');
	INSERT INTO DEPT_UPDATE HISTORY
	VALUES(:OLD.DNO,:OLD.DNAME,:OLD.LOC,:NEW.DNO,:NEW.DNAME,:NEW.LOC);
	--UPDATE이전:OLD.DNO 40, :NEW.DNO NULL;
	--UPDATE이후:OLD.DNO 40, :NEW.DNO 수정된 값;
END;

select*from user_constraints where table_name='DEPT';

select*from dept;

create table dept_up_history
as
select dno olddno,dname olddname,loc oldloc,dno newdno,dname olddname,loc newloc,regdate updatedate
from dept where 1<>1;

DROP TABLE DEPT_UP_HISTORY;
SELECT*FROM DEPT_UP_HISTORY;



