--1.
select e.ename,e.dno,d.dname
			from EMPLOYEE e,DEPARTMENT d
			where e.dno=d.dno
and e.ename='SCOTT';

--2.
select ename,dname,loc
from EMPLOYEE e join DEPARTMENT d
on e.dno=d.dno
order by dname;

--3.
select dno,job,loc
from EMPLOYEE e join department d
using(dno)
where dno=10;

--4.
select ename,dname,loc
from EMPLOYEE natural join department
where commission>0;

--5.
select ename,dname
from EMPLOYEE e, DEPARTMENT d
where e.dno=d.dno
and e.ename like'%A%';

--6.
select ename,job,dno,dname
from EMPLOYEE e natural join department d
where loc='NEW YORK';

--7.
select a.ename"Employee",a.eno"Emp#",b.ename"Manager",b.eno"Mgr#"
from EMPLOYEE a,employee b
where a.manager=b.eno;

--8.
select a.ename"Employee",a.eno"Emp#",b.ename"Manager",b.eno"Mgr#"
from EMPLOYEE a,employee b
where a.manager=b.eno(+)
order by a.eno desc;

--9.
select a.ename,b.eno,b.ename
from employee a,employee b
where a.dno=b.dno
and a.ename='SCOTT'
and b.ename!='SCOTT';

--10.
select a.ename,a.hiredate
from employee a,employee b
where a.hiredate>b.hiredate
and b.ename='WARD'

--11.
select a.ename,a.hiredate,b.ename,b.hiredate
from employee a, employee b
where a.hiredate<b.hiredate
and a.manager=b.eno