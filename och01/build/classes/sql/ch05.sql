select*from DEPARTMENT;
select*from EMPLOYEE,DEPARTMENT order by EMPLOYEE.dno,eno;
--두테이블의 행수끼리 곱한 행,employee:14행, department:4행 56행
--카티션곱

--join
--두 테이블의 칼럼이 같은 것끼리 추출
select*from EMPLOYEE,DEPARTMENT
where EMPLOYEE.dno=DEPARTMENT.dno
order by EMPLOYEE.dno,eno;

select eno,ename,EMPLOYEE.dno,dname--병합된 행중에서 필요한 칼럼 추출
			from EMPLOYEE,DEPARTMENT
			where EMPLOYEE.dno=DEPARTMENT.dno--칼럼이 맞는것끼리 병합,추출
order by EMPLOYEE.dno,eno;

--테이블에 별칭:테이블명 별칭
select eno "사번",ename "이름",e.dno "부서",dname "부서명"
			from EMPLOYEE e,DEPARTMENT d
			where e.dno=d.dno
order by e.dno,eno;

select eno,ename,e.dno,dname
from EMPLOYEE e,DEPARTMENT d
where e.dno=d.dno
and e.eno=7788
order by e.dno,eno;	

--natural join
select eno, ename,dno,dname from EMPLOYEE e natural join DEPARTMENT d where e.eno=7788;

select eno,ename,dno,dname from EMPLOYEE e join DEPARTMENT d using(dno)where e.eno=7788;

select eno,ename,e.dno,dname from EMPLOYEE e join DEPARTMENT d on e.dno=d.dno where e.eno=7788;

--non-equi-join
select*from salgrade;
select eno,case when salary>=700 and salary<=1200	then'1'
						when salary>=1201 and salary<=1400	then'2'
						when salary>=1401 and salary<=1200	then'3'
						when salary>=2001 and salary<=3000	then'4'
						when salary>=3001 and salary<=9999	then'5' end as grade
 from EMPLOYEE order by eno;
 
 --하나의 칼럼에 두개의 조건(범위)로 조인 - non-equi-join
 select eno, salary, grade from EMPLOYEE e,SALGRADE s where salary between losal and hisal;
 
 select eno,salary,grade from EMPLOYEE e,SALGRADE s where salary>=losal and salary<=hisal;
 
 create table sg(
 grade varchar2(10) ,
 low number(3),
 hi number(3)
 );
 
 create table st(
 sno number primary key,
 name varchar2(50),
 score number(3)
 );
 
 --등급
 insert into sg values('A',90,100);
 insert into sg values('B',80,89);
 insert into sg values('C',70,79);
 insert into sg values('F',0,69);
 
 --점수
 insert into st values(1,'홍길동',87);
 insert into st values(2,'일지매',98);
 insert into st values(3,'임꺽정',59);
 
 select*from sg;
 select*from st;
 
 --비 동등 조인
 select sno,name,score,grade from st,sg where score between low and hi;
 
 select*from LOCATIONS;--주소테이블
 select*from REGIONS;--지역테이블
 select*from COUNTRIES;--국가테이블
 select*from EMPLOYEES;--사원테이블
 select*from DEPARTMENTS;--부서테이블
 
 --A->B,B->C,:A->C
 select EMPLOYEE_id,
 first_name,
 last_name,
 salary,
 e.department_id,
 d.department_name,
 d.location_id,
 l.street_address,
 l.city,
 l.country_id,
 c.country_name,
 c.region_id,
 r.region_name
 from DEPARTMENTS d, EMPLOYEES e, COUNTRIES c, LOCATIONS l,REGIONS r
 where e.department_id=d.department_id and d.location_id=l.location_id and l.country_id=c.country_id
 and c.region_id=r.region_id
 order by c.region_id,l.country_id,e.department_id,employee_id;
 
 --
 select e.ename,d.dname,salary,grade from EMPLOYEE e,DEPARTMENT d,SALGRADE s
 where e.dno=d.dno and salary between losal and hisal;
 
 --self-join:하나의 테이블을 별칭을 다르게 부여하여 join하는 방식
 --계층구조로 만들어진 테이블에 적용.
 select a.eno"사번",a.ename"이름",a.manager"관리자",b.ename"관리자명"from EMPLOYEE a, EMPLOYEE b
 where a.manager=b.eno;
 
create table stud(
sno number primary key,--학생번호
name varchar2(50),--이름
year number,--학년
mento number--멘토 번호
);

insert into stud values(1,'홍길동',1,3);
insert into stud values(2,'일지매',1,4);
insert into stud values(3,'임꺽정',1,4);
insert into stud values(4,'이순신',3,5);
insert into stud values(5,'김길동',1,null);

select a.sno"학번",a.name"이름",a.year"학년",a.mento"멘토번호", b.name"멘토명"
from stud a,stud b
where a.mento=b.sno;

--outer-join null값이 있는 칼럼도 보여주는 경우 (+)기호로 표시
select a.sno"학번",a.name"이름",a.year"학년",a.mento"멘토번호", b.name"멘토명"
from stud a,stud b
where a.mento(+)=b.sno;

select*from EMPLOYEE a, EMPLOYEE b where a.manager=b.eno(+);--비어있는 칼럼이 있는 경우 조회

select*from department;
select*from employee a, department b where a.dno(+)=b.dno;
select*from stud;

--ansi join:left outer join on 조건
select*from employee a left outer join employee b on a.manager=b.manager;