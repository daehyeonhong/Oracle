--ex01.커미션이 null이 아닌 상태의 사원번호,이름,급여 ..이름 기준으로  오름차순 정렬결과
--저장하는 프로시져
drop table emp_sal;
select*from emp_sal;
create table emp_sal as select eno,ename,salary from employee where 1<>1;

--프로시져 생성
create or replace procedure sp_commission
is
cursor c1 is select*from employee where commission is not null;
begin
	dbms_output.put_line('사번  이름    급여');
	dbms_output.put_line('──────────');
	for v_emp in c1 loop
	exit when c1%notfound;
	dbms_output.put_line(v_emp.eno||'  '||v_emp.ename||'  '||v_emp.salary);
	insert into emp_sal values(v_emp.eno,v_emp.ename,v_emp.salary);
	end loop;
	commit;
end;
select*from emp_sal;

select object_name,object_type,status from user_objects where object_name='SP_COMMISSION';
--ex3. 사번 이름 급여 커미션
alter table emp_sal add commission number;


select object_name,object_type,status from user_objects where object_name='SP_COMM2';
create or replace procedure sp_comm2
is cursor c1 is select*from employee where commission is not null;
begin
	dbms_output.put_line('사번 이름 급여 커미션');
	dbms_output.put_line('────────────');
	for v_emp in c1 loop
	exit when c1%notfound;
	dbms_output.put_line(v_emp.eno||'  '||v_emp.ename||'  '||v_emp.salary||'  '||v_emp.commission);
	insert into emp_sal values(v_emp.eno,v_emp.ename,v_emp.salary,v_emp.commission);
end loop;
commit;
end;