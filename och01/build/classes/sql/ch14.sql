-- pl/sql
-- 절차적 프로그래밍 기능의 sql문
-- 선언부,실행부,예외부로 구성
set serveroutput on
begin
	dbms_output.put_line('Welcome to Oracle');
end;
/

declare    
v_eno employee.eno%type;             
v_ename employee.ename%type;          
begin                           
v_eno:=7788;                         
v_ename:='SCOTT';                
dbms_output.put_line('사원번호 사원명');
dbms_output.put('---------------------');
dbms_output.put_line('');   
dbms_output.put_line(v_eno||'      '||v_ename);
end;
/

set serveroutput on
declare
v_eno employee.eno%type;
v_ename employee.ename%type;
begin
	dbms_output.put_line('사원번호 사원명');
	dbms_output.put_line('------------');
	
	select eno,ename
	into v_eno,v_ename	--select한 결과를 변수에 저장
	from employee
	where ename=upper('scott');
	dbms_output.put_line(v_eno||'		'||v_ename);
end;
/

-- 사번이 7788인 사원의 이름,업무,급여,입사일을 출력하는 pl/sql문 작성
-- 선언부
set serveroutput on
declare
v_ename employee.ename%type;
v_job employee.job%type;
v_salary employee.salary%type;
v_hiredate employee.hiredate%type;

-- 실행부
begin
	dbms_output.put_line('사원명		업무		급여		입사일');
	dbms_output.put_line('----------------------');
	
	select ename,job,salary,hiredate
	into v_ename,v_job,v_salary,v_hiredate
	from employee
	where eno=7788;
	dbms_output.put_line(v_ename||'		'||v_job||'		'||v_salary||'		'||v_hiredate);
	
	dbms_output.put_line('이름: '||v_ename);
	dbms_output.put_line('직책: '||v_job);
	dbms_output.put_line('급여: '||v_salary||'$');
	dbms_output.put_line('입사일자: '||v_hiredate);	
end;
/

-- 사번이 7788인 사원의 이름,업무,급여,입사일을 출력하는 pl/sql문 작성
-- 선언부
set serveroutput on
-- structure|recored type변수
declare
v_info employee%rowtype;
-- 실행부
begin
	select*
	into v_info
	from employee
	where eno=7788;
	dbms_output.put_line('이름: '||v_info.ename);
	dbms_output.put_line('직책: '||v_info.job);
	dbms_output.put_line('급여: '||v_info.salary||'$');
	dbms_output.put_line('입사일자: '||v_info.hiredate);	
end;
/

-- 제어문 if-elsif-else - end if;
declare	--	선언부
v_employee employee%rowtype;
temp number(4):=1;
annsal number(7,2);	--	전체 자릿수가 7자리, 소숫점 자릿수 2자리, 정수자리 4자리
begin	--	실행부
	select*
	into v_employee
	from employee
	where ename=upper('scott');
	
	--	if	조건	then	실행문;	end if;
	if(v_employee.commission is null)then
	v_employee.commission:=0;
	end if;
	
	annsal:=v_employee.salary*12+v_employee.commission;
	dbms_output.put_line('사원번호	사원이름	연봉');
	dbms_output.put_line('--------------------------');
	dbms_output.put_line(v_employee.eno||'	'||v_employee.ename||'	'||annsal);
end;
/

--	if	~	elsif	~	end	if;
declare
v_eno employee.eno%type;
v_ename employee.ename%type;
v_dno employee.dno%type;
v_dname department.dname%type;
begin
	select eno,ename,dno
	into v_eno,v_ename,v_dno
	from employee
	where ename=upper('scott');
	if(v_dno=10)then				--	값 비교:v_dno	=	값
	v_dname:='Accounting';	-- 값 저장:v_dname := 값
	elsif v_dno=20 then
	v_dname:='Research';
	elsif v_dno=30 then
	v_dname:='Sales';
	elsif v_dno=40 then
	v_dname:='Operations';	
	end if;
	
	dbms_output.put_line('사번		이름		부서명');
	dbms_output.put_line(v_eno||'		'||v_ename||'		'||v_dname);
end;
/

-- loop문
--	반복문
declare	--선언부
v_dan number:=2;	--변수 선언 및 값 초기화
v_i	number:=1;
begin
	loop
	v_dan:=v_dan+1;

	loop
	dbms_output.put_line(v_dan || '*' || v_i||'='||(v_dan*v_i)||'	');
	v_i:=v_i+1;	--증가식
	if v_i>9 then
	exit;
	end if;
	end loop;	
	if v_dan>9 then
	exit
	end loop;
end;



-- for loop
declare dan number:=2; -- 변수 선언 및 초기화, 변수 := 값;
u number:=1; -- 변수:=값;
begin
	for i in 1..9 loop -- for 변수 in 하한..상한 loop
	dbms_output.put_line(dan||'*'||i||'='||(dan*i));
	end loop;
	end;
/

declare dan number:=2; -- 변수 선언 및 초기화, 변수 := 값;
u number:=1; -- 변수:=값;
begin
	for i in 1..9 loop -- for 변수 in 하한..상한 loop
	dbms_output.put(dan||'*'||i||'='||(dan*i)||' ');
	end loop;
	dbms_output.put_line(' '); -- put()함수의 내용을 출력하기 위해 put_line()추가
	end;
/

--구구단 이중 loop
declare
dan number:=2;
i number:=1;
begin
	for dan in reverse 2..9 loop	-- for 변수 in 하한..상한 loop
	for i in reverse 1..9 loop		-- for 변수 in 하한..상한 loop
	dbms_output.put(dan||'*'||i||'='||(dan*i)||' ');
	end loop;
	dbms_output.put_line(' ');
	end loop;
end;

-- while 반복문
-- while 조건 loop ~~~ end loop
set serveroutput on
declare -- 선언부
dan number:=2;
i number:=1;-- 초기값
begin -- 실행부
while dan<=9 loop
		while i<=9 loop
		dbms_output.put(dan||'*'||i||'='||(dan*i)||' ');
		i:=i+1; -- 증가식 변수:=증가값;
		end loop;
		dbms_output.put_line(' ');
		dan:=dan+1; -- 증가식 변수:=증가값;
		i:=1;-- 안쪽 반복문 변수 값 1로 초기화
		end loop;
end;


-- cursor [cursor_name] is select 문;
-- 여러행의 데이터를 한번에 처리하는 객체
declare -- 선언부
v_dept department%rowtype; -- 참조타입 dno,dname,loc 값을 저장
-- cursor 변수 is 쿼리문;
cursor c1 is select*from department; -- 커서 생성
begin -- 실행부
	dbms_output.put_line('부서번호 부서명 지역명');
	dbms_output.put_line('───────────────────────');
	open c1; -- cursor open
	if not c1%isopen then
	open c1;
	dbms_output.line('c1 열기');
	else
	dbms_output.line('c1 오픈됨');
	end if;
	loop
	dbms_output.put_line('실행된 건수: '||c1%rowcount); -- rowcount 실행 건수
	fetch c1 into v_dept.dno,v_dept.dname,v_dept.loc;
	exit when c1%notfound; -- 반복문 빠져나가는 조건
	dbms_output.put_line(v_dept.dno||' '||v_dept.dname||' '||v_dept.loc);
	if c1%found then -- 레코드 조회 여부에 따라 true||false;
	dbms_output.put_line('레코드 있음');
	end if;	
	end loop;
	close c1; -- cursor close
end;

select*from department;

-- open문, fetch문 생략 -> for loop문으로 처리
declare -- 선언부
v_dept department%rowtype;
cursor c1 is select*from department order by dno;
begin -- 실행부
	dbms_output.put_line('부서번호 부서명        지역명');
	dbms_output.put_line('───────────────────');
	for v_dept in c1 loop -- cursor c1 자동 오픈
	exit when c1%notfound;
	dbms_output.put_line(v_dept.dno||'        '||v_dept.dname||'        '||v_dept.loc);
	end loop;
end;