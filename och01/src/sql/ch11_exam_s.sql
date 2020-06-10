--ex01.
create view v_em_dno
as select eno,ename,dno
from EMPLOYEE
where dno=20;
select*from v_em_dno;

--ex02.
create or replace view v_em_dno
as select eno,ename,dno,salary
from EMPLOYEE
where dno=20;
select*from v_em_dno;

--ex03.
drop view v_em_dno;