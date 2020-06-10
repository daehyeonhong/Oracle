select*from DEPARTMENT;
insert into DEPARTMENT values(60,'SALES','L.A');
select eno,ename,a.dno,dname from EMPLOYEE a,DEPARTMENT b where a.dno=b.dno and job='CLERK' and a.dno=20;
delete from DEPARTMENT where dno=60;

select*from user_objects where object_type='PROCEDURE';

select*from user_objects where object_type='PROCEDURE'order by object_name;

select text from user_source where name='PR_EMP_UPSAL';

create or replace procedure pr_emp_upSal(tot out number)as begin update employee set salary = salary + salary*0.05;
commit;select sum(salary)into tot from employee;end;

select*from user_objects where object_type='FUNCTION';
SELECT TEXT FROM USER_SOURCE WHERE NAME='FN_SALARY_ENAME';

CREATE OR REPLACE
function fn_salary_ename(  
v_ename in employee.ename%type)  
return number
IS V_SALARY NUMBER(7,2);
BEGIN
SELECT SALARY INTO V_SALARY FROM EMPLOYEE WHERE ENAME=V_ENAME;
RETURN V_SALARY;
END;

-- 실행
variable v_sal number;
-- exec:변수:=함수명(값);
exec:v_sal:=fn_salary_ename('SMITH');
PL/SQL procedure successfully completed.

-- 결과 출력 print [variable_name]
print v_sal;

     V_SAL
----------
   1125.68
   
SELECT*FROM EMPLOYEE;


select*from user_objects where object_type='PROCEDURE'order by object_name;
SELECT TEXT FROM USER_SOURCE WHERE NAME='SP_SALARY_ENAME2';

create or replace procedure sp_salary_ename2(
v_ename in employee.ename%type,
v_salary out employee.salary%type
)
as
begin
	select salary
	into v_salary
	from employee
	where ename=v_ename;
end;

--실행
variable v_sal number;
exec:v_sal:=fn_salary_ename('SMITH');

PL/SQL procedure successfully completed.

print v_sal;

     V_SAL
----------
   1125.68
   
variable v_sal number;
exec sp_salary_ename2('SMITH',:v_sal);

PL/SQL procedure successfully completed.

print v_sal

     V_SAL
----------
   1125.68
   
   
   
   
SELECT*FROM USER_OBJECTS WHERE OBJECT_NAME='FN_HIRE_ENO';
SELECT TEXT FROM USER_SOURCE WHERE NAME='FN_HIRE_ENO'

CREATE OR REPLACE function fn_hire_eno
(v_eno number) --매개변수 선언
return varchar2--결과처리 리턴타입 지정 선언
as
v_date date;
BEGIN
	SELECT HIREDATE
	INTO V_DATE
	FROM EMPLOYEE
	WHERE ENO=V_ENO;
	RETURN TO_CHAR(V_DATE);
END;


-- 실행
VARIABLE V_DATE VARCHAR2(20);
EXEC:V_DATE:=FN_HIRE_ENO(7788);
PL/SQL procedure successfully completed.
PRINT V_DATE;
V_DATE
--------------------------------------------------------------------------------
87/07/13


select*from employee;