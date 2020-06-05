create or replace trigger trriger_sample
after insert
on trt
for each row
begin
	if inserting then--updating,deleting
	 dbms_output.put_line('insertt Trigger 발생');
	 insert into trt_history
	 values(:new.eno);--:new.칼럼,:old.칼럼
	 -- 입력전 :new.dno의 값은 null, :old.dno의 값 null
	 -- 입력후 :new.dno의 값은 입력값, :old.dno의 값 null,
	end if;
end;
create table trt_history as select eno from trt where 1<>1;
drop trigger trriger_sample;
drop table trt;
select*from trt;
create table trt
as select*from employee
where 1<>1;