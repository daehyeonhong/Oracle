-- 조건 비교연산 where 칼럼 = 값
select * from EMPLOYEE where dno=10 ;
--칼럼 dno의 값은 숫자

select * from EMPLOYEE where ename='SCOTT';
--칼럼 ename의 값은 문자 (홑따옴표)'값'

--날짜 비교 where 칼럼<= '날짜'
select * from EMPLOYEE
where hiredate <='1981/01/01';

--조회 조건
--같다(=)
select eno, ename, salary from EMPLOYEE where salary=1500;
--보다 크다(>)
select eno, ename, salary from employee where salary>1500;

select eno, ename, salary from EMPLOYEE where salary<1500;
--보다 크거나 같다
select eno, ename, salary from EMPLOYEE where salary>=1500;
--보다 작거나 같다
select eno, ename, salary from EMPLOYEE where salary<=1500;
--같지 않다(!=,<>,^=)
select eno, ename, salary from EMPLOYEE where salary!=1500;
select eno, ename, salary from EMPLOYEE where salary<>1500;
select eno, ename, salary from EMPLOYEE where salary^=1500;

--비교연산결과-칼럼 추출 안됨.
--select 10>5, 10<5, 10>=5, 10<=5, 10!=5 from dual;비교 불가

--논리연산 and, or, not
select * from EMPLOYEE where dno=10 and job='MANAGER';
select * from EMPLOYEE where dno=10 or job='MANAGER';
select * from EMPLOYEE where  not dno=10;

--범위 연산자 between A and B,				1000<=salary<=1500
select * from EMPLOYEE where salary between 1000 and 1500;
select * from EMPLOYEE where salary>=1000 and salary<=1500;
-- salary	<1000 and 1500<salary
select * from EMPLOYEE where salary<1000 or salary>1500;
select * from EMPLOYEE where salary not between 1000 and 1500;
--날짜 범위
select * from EMPLOYEE where hiredate between '1981/02/03' and '1981/11/17';

--in 연산자- 나열된 값 중 하나에 해당하는 값 추출
select * from EMPLOYEE where commission in (300,500,1400);

-- like % | _
select * from EMPLOYEE where ename like '%A%';
--길이 상관없이 D포함
select * from EMPLOYEE where ename like '%D%';
select * from EMPLOYEE where ename like '_D_';
--길이가 1인 문자(char)를 포함하는 E
select * from EMPLOYEE where ename like '%E_';

select * from EMPLOYEE where ename like '_A%';
--두번째 단어가 A가 포함된 문자열

-- is null | is not null - 해당 칼럼의 값이 null인지 여부 확인
select * from EMPLOYEE where commission is null;
select * from EMPLOYEE where commission is not null;