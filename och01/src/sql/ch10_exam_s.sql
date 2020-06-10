--ex01. eno->primary key constraint my_emp_pk_test
drop table emp_sample_test;
select*from emp_sample_test;
create table emp_sample_test as select*from EMPLOYEE;
alter table emp_sample_test add constraint my_emp_pk_test primary key(eno) ;
--제약조건 조회
select*from user_constraints where table_name='EMP_SAMPLE_TEST';

--ex02. dno primary key my_dept_pk_test
drop table emp_sample_test;
create table emp_sample_test as select*from EMPLOYEE where 1=0;
alter table emp_sample_test add constraint my_dept_pk_test primary key(dno);

select*from user_constraints where table_name='EMP_SAMPLE_TEST';

--ex03. dno not null my_emp_dept_fk_test
alter table emp_sample_test add constraint my_emp_dept_fk_test foreign key(dno) references department(dno);
select*from user_constraints where table_name='EMP_SAMPLE_TEST';

--ex04. commission>0
update emp_sample_test set commission=nvl(commission,0);
select*from emp_sample_test;
alter table emp_sample_test add constraint emp_commission_min_test check(commission>=0);
select*from user_constraints where table_name='EMP_SAMPLE_TEST';