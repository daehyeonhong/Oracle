--procedure
create or replace procedure ps_commission_up
is
begin
		update EMPLOYEE
			set commission=salary*0.05
		where salary>3000;
		commit;
end;

select*from EMPLOYEE;
-- 프로시져 생성 상태 확인 status가 valid면 정상
select object_name,object_type,status from user_objects where object_name='PS_COMMISSION_UP';
-- 프로시져 실행
exec ps_commission_up;

select*from employee where salary>3000;

-- 매개변수가 있는 프로시져 --7788 사원이 근무하는 부서의 총 급여액 출력
create or replace procedure ps_dept_tot
(
	v_eno in employee.eno%type, -- 값을 받는 매개변수 in모드
	v_tot out employee.salary%type -- 값을 출력하는 매개변수 타입 out모드
)
is
begin
	select sum(salary)
		into v_tot
		from employee
		where dno=(select dno from employee where eno=v_eno);
end;
-- 상태 확인
select object_name,status from user_objects where object_name='PS_DEPT_TOT';

--실행
-- 변수 선언
-- variable [variable name]
variable v_saltot number;

-- 실행
-- execute [procedure name](in mode,:out mode);
exec ps_dept_tot(7788,:v_saltot);

procedure successfully completed.
-- print out 변수
print v_saltot;

V_SALTOT
----------
11989.69


-- 함수 return 문을 가진 객체
create or replace function fn_jobname
(v_eno employee.eno%type)	--argument
return varchar2		--return type
is
v_job employee.job%type;
begin
	select job
		into v_job
		from employee
		where eno=7788;
		return v_job;
end;
-- 프로시져 상태 확인
select object_name,object_type,status from user_objects where object_type='FUNCTION';

-- 실행
-- 변수선언
variable v_jobname varchar2(20);
-- 실행 후 결과
exec :v_jobname:=fn_jobname(7788);
-- 결과 출력
print v_jobname;

V_JOBNAME
--------------------------------------------------------------------------------
ANALYST


-- 트리거
create table emp_history
as
select eno oldeno,ename oldename,job oldjob,dno olddno,
			eno neweno,ename newename,job newjob,dno newdno,sysdate chgdate
	from employee
where 1<>1;

select*from emp_history;

-- trigger 생성
create or replace trigger tr_empchg
after update		-- 타이밍: 직후,이벤트: update
on employee		-- 트리거 작동 테이블: employee
for each row		-- 행 단위 처리
begin
	DBMS_OUTPUT.PUT_LINE('UPDATE TRIGGER 실행');
	INSERT INTO EMP_HISTORY
		VALUES(	:OLD.ENO,:OLD.ENAME,:OLD.JOB,:OLD.DNO,						-- 칼럼의 이전값:OLD속성
						:NEW.ENO,:NEW.ENAME,:NEW.JOB,:NEW.DNO,SYSDATE);	-- 칼럼의 이후값:NEW속성
end;

SELECT OBJECT_NAME,STATUS FROM USER_OBJECTS WHERE OBJECT_TYPE='TRIGGER';
-- 트리거 활성화/비활성화 여부 확인
SELECT TRIGGER_NAME,TRIGGERING_EVENT,STATUS
	FROM USER_TRIGGERS
WHERE TRIGGER_NAME='TR_EMPCHG';

-- 트리거 상태 확인
SELECT OBJECT_NAME,OBJECT_TYPE,STATUS FROM USER_OBJECTS WHERE OBJECT_NAME='TR_EMPCHG';

SELECT*FROM EMPLOYEE WHERE ENO=7788;	--	JOB:'MANAGER',DNO:30

-- TABLE DATE 수정
UPDATE EMPLOYEE
SET JOB='MANAGER',DNO=30
WHERE ENO=7788;

SELECT*FROM EMP_HISTORY;

UPDATE EMPLOYEE
SET ENAME='TMZHT',
JOB='ANALYST',
DNO=20
WHERE ENO=7788;
UPDATE TRIGGER 실행
1 row updated.

SQL> COMMIT;
Commit complete.