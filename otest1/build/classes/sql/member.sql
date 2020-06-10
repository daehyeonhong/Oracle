create table member1(
mno number primary key,
name varchar2(50),
password varchar2(20),
address varchar2(150)
);
select * from member1;
select nvl(max(mno),0)+1 from member1;