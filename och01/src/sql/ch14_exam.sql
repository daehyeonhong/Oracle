-- ex01. if문을 사용하여 king사원의 부서번호를 얻어와 부서번호에 따른 부서명 출력
declare
v_dname department.dname%type;
v_dno department.dno%type;
begin
	select dno
	into v_dno
	from EMPLOYEE
	where ename=upper('king');
	if v_dno=10 then
	v_dname:='ACCOUNT';
	elsif V_dno=20 then
	V_DNAME:='RESEARCH';
	elsif V_dno=30 then
	V_DNAME:='SALES';
	elsif V_dno=40 then
	V_DNAME:='OPERATION';
	end if;
	DBMS_OUTPUT.PUT_LINE('KING의 부서번호는 '||V_DNO||' '||'부서명은 '||V_DNAME);
end;


-- ex02.
-- basic loop 1~10사이의 자연수 합 구하기
declare	-- 선언부
tot number:=0;
n number:=1;
begin
	loop -- basic loop
	tot:=tot+n;
	n:=n+1;
	if n>10 then -- loop 탈출 조건
	exit; -- loof 탈출 명령문
	end if;
	end loop;
	dbms_output.put_line('총합: '||tot);
end;

-- ex03. for loop 1..10 합
declare -- 선언부
tot number:=0;
begin -- 실행부
	for i in 1..10 loop -- for 변수 in 하한..상한 loop
	tot:=tot+i;
	end loop;
	dbms_output.put_line('총합: '||tot);
end;

-- ex04. while loop 1~10 자연수의 합
declare
n number:=1;
tot number:=0;
begin
	while n<=10 loop
	tot:=tot+n;
	n:=n+1;
	end loop;
	dbms_output.put_line('총합 : '||tot);
end;

declare
n number:=1;
tot number:=0;
begin
	while n<=10 loop
	if mod(n,2)=0 then -- mod(피제수,제수)=나머지 -> 나머지 함수
	tot:=tot+n;
	end if;
	n:=n+1;
	end loop;
	dbms_output.put_line('총합 : '||tot);
end;

-- ex05. 사원 테이블 커미션 값이 null이 아닌 사원의 사원번호,이름,급여를 급여 기준 asc

select eno,ename,salary from employee order by eno;
declare
v_emp employee%rowtype;
cursor c1 is select*from employee where commission is not null;
									-- 1. 커서 생성
begin
	dbms_output.put_line('사번  이름  급여');
	dbms_output.put_line('────────────────────');
	open c1;					-- 2. 커서 오픈
	loop
	fetch c1 into v_emp;	-- 3. fetch
	exit when c1%notfound;
	dbms_output.put_line(v_emp.eno||'  '||v_emp.ename||'  '||v_emp.salary);
	end loop;
	close c1;					-- 4. 커서 닫기
end;

declare
v_emp department.dno%type;
begin
	select dno
	into v_dno
	from employee
	where ename=upper('king');
	DBMS_OUTPUT.PUT_LINE(v_emp);
end;