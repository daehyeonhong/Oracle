--1.사원들의 입사년도와 입사한 달, substr()
--yy-mm-dd
select substr(hiredate,1,2),substr(hiredate,4,2) from EMPLOYEE;

--2.4월에 입사한 사원 출력
select*from employee where substr(hiredate,4,2)='04';
select*from employee where to_char(hiredate,'mm')='04';

--3.MOD, 사원번호가 짝수 mod(사원번호,2)=0
select *from employee where mod(eno,2)=0;
--사원번호가 홀수인 직원
select *from employee where mod(eno,2)!=0;

--4.연도2자리(YY),월숫자(MM),요일 약어(DY)
select eno,ename,to_char(hiredate,'yy'),
			to_char(hiredate,'mm'),
			to_char(hiredate,'dy')
			from EMPLOYEE
order by eno;

--5. 날짜 계산
select sysdate,trunc(sysdate,'yy'),trunc(sysdate-trunc(sysdate,'yy'))from dual;

--6.사원들의 상관 사원번호 출력 null인 경우 0으로 대체
select eno,ename,nvl(manager,0) from EMPLOYEE order by eno;

--7.DECODE함수
select eno,ename,job,salary,salary+	(decode(job,
				'ANALIST',200,
				'SALESMAN',180,
				'MANAGER',150,
				'CLERK',100,
				0)--default값
				)as update_salary
from EMPLOYEE;