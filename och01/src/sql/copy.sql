select 'Oracle Mania',
upper('Oracle Mania'),
lower('Oracle Mania'),
initcap('Oracle Mania')
from dual;

select eno, initcap(ename),job,dno from EMPLOYEE
where job=upper('manager');
select eno, initcap(ename),job,dno from EMPLOYEE
where lower(job)='manager';

select'Oracle Mania',length('Oracle Mania'),length('오라클매니아')from dual;
select'Oracle Mania',length('Oracle Mania'),length('오라클매니아')from dual;
select*from EMPLOYEE where length(ename)=4;
select'Oracle','Mania',concat('Oracle','Mania'),'Oracle'||'Mania'from dual;

select'hello','i am',' dooly',concat(concat('hello','i am'),' dooly'),
'hello'||' i am'||' dooly'from dual;

select concat(concat(concat(concat('hi',' i'),' am'),' a'),' boy')from dual;

select substr('Oracle Mania',4,3)from dual;
select substr('Oracle Mania',-4,3)from dual;

select*from EMPLOYEE where substr(ename,-1,1)='N';
select*from EMPLOYEE where ename like '%N';

select*from EMPLOYEE where substr(hiredate,1,2)='87';
select substr('Oracle Mania',4,3),substrb('Oracle Mania',4,3)from dual;
select substr('오라클매니아',3,4),substrb('오라클매니아',3,4)from dual;

select instr('Oracle Mania','a'),
			instr('Oracle Mania','a',2),
			instr('Oracle Mania','a',5,1),
			instr('Oracle Mania','f')
from dual;
select instrb('Oracle Mania','a'),
			instrb('Oracle Mania','a',2),
			instrb('Oracle Mania','a',5,1),
			instrb('Oracle Mania','f')
from dual;

select*from EMPLOYEE where instr(ename,'A')>0;
select*from EMPLOYEE where instr(ename,'A')=0;

select eno,ename,lpad(salary,10,'*')from EMPLOYEE order by eno;
select eno,ename,rpad(salary,10,'*')from EMPLOYEE order by eno;

select' Oracle Mania ',length(' Oracle Mania '),' Oracle Mania ',length(trim(' Oracle Mania '))from dual;
select' Oracle Mania ',trim('O'from'Oracle Mania'),trim('a'from'Oracle Mania'),trim('c'from'Oracle Mania')from dual;

select eno,initcap(ename),initcap(job)from EMPLOYEE where job = upper(trim(' Manager '));
select 'Oracle Mania',replace('Oracle Manaia','a','i')from dual;
select 98.7654,round(987654,2),round(98.7654,-1)from dual;
select 98.7654,trunc(98.7654),trunc(98.7654,2),trunc(98.7654,-1)from dual;
select 98.7654,ceil(98.7654)from dual;
select mod(10,2),10/2 from dual;
select '10을 2로 나누면 몫이'||(10/2)||'이고, 나머지가 '||mod(10,2)||' 이다'from dual;
select concat(concat('10을 2로 나누면 몫이 ',(10/2)),concat(concat('이고, 나머지가 ',mod(10,2)),' 이다'))from dual;

select sign(-5),sign(5),sign(0),abs(-5)from dual;
select floor(12.345),floor(12.765),power(3,2),power(2,4)from dual;
select sysdate from dual;
select sysdate-1 어제,sysdate 오늘,sysdate+1 내일,sysdate+2 모레 from dual;
select sysdate,round(months_between(sysdate,sysdate-100)),sysdate-100 from dual;
select eno,initcap(ename),hiredate,round(months_between(sysdate,hiredate)),round(months_between(sysdate,hiredate)/12)from EMPLOYEE;
select sysdate,add_months(sysdate,2),add_months(sysdate,-2)from dual;
select sysdate,last_day('20/05/23'),last_day(sysdate),last_day(add_months(sysdate,-3))from dual;
select sysdate,next_day(sysdate,'월요일'),next_day(sysdate,'토요일')from dual;
select round(sysdate),sysdate from dual;
select round(sysdate,'CC'),round(sysdate,'yyyy'),round(sysdate,'d'),round(sysdate,'day'),round(sysdate,'dd'),round(sysdate,'hh'),round(sysdate,'q'),round(sysdate,'month'),round(sysdate,'mi')from dual;
select trunc(sysdate,'CC'),trunc(sysdate,'yyyy'),trunc(sysdate,'d'),trunc(sysdate,'day'),trunc(sysdate,'dd'),trunc(sysdate,'hh'),trunc(sysdate,'q'),trunc(sysdate,'month'),trunc(sysdate,'mi')from dual;
select sysdate,to_char(sysdate,'yyyy'),to_char(sysdate,'yy'),to_char(sysdate,'mm'),to_char(sysdate,'mon'),to_char(sysdate,'day'),to_char(sysdate,'dy'),to_char(sysdate,'d'),to_char(sysdate,'dd'),to_char(sysdate,'yyyy-mm-dd day')from dual;
select eno,ename,hiredate from EMPLOYEE where to_char(hiredate,'yy')='87';
select to_date('20200526','yyyymmdd'),to_date('20200526','yyyy-mm-dd'),to_date('2020-05-26','yyyy-mm-dd'),to_date('20200525'),to_date('20-05-26')from dual;
select to_number('10000')-to_number('5000'),to_number('100,000','999,999')-to_number('50,000','999,999'),to_number(to_char(last_day(sysdate),'dd')),to_char(sysdate,'dd')-to_char(last_day(sysdate),'dd')from dual;
select commission,nvl(commission,0)from EMPLOYEE;
select ename,salary,commission,nvl2(commission,salary*12+commission,salary*12),salary*12+commission from EMPLOYEE;
select ename,nullif(dno,10),dno from EMPLOYEE;
select nullif('A','A'),nullif('B','A')from dual;
select coalesce(null,1,2),coalesce(null,null,1,2),coalesce(null,null,1,2,null)from dual;
select dno,decode(dno,10,'회계부서',20,'연구부서','30','영업부서',40,'관리부서')as dname from department;
select*from EMPLOYEE order by salary;
select salary, round(salary/1000),decode(round(salary/1000),1,'C',2,'B',3,'A',5,'S','K')from EMPLOYEE order by salary;
select'private'||decode(data_type,'VARCHAR2','String','NUMBER','int','DATE','Date',data_type)||' '||lower(column_name)from cols where table_name='BOARD';
select dno,dname,case dno when 10 then'회계'when 20 then'연구'when 30 then'영업'when 40 then'관리'else'기타'end as dname from department;
select dno,dname,case when dno=10 then'회계' when dno=20 then'연구'when dno=30 then'영업'when dno=40 then'관리'else'기타'end as dname from department;
select case when 76>=90 then'A'when 76=80 then'B'when 86>=70 then'C' else'F' end as score from dual;

select*from EMPLOYEE where ename like upper('%n');