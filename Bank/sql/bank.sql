create table bank(
ano varchar2(15),
owner varchar2(20)not null,
balance number default 0,
password varchar2(20)not null,
signdate date default sysdate,
primary key(ano)
);
select*from bank;
drop table bank;
truncate table bank;

insert into bank(ano,owner,balance,password) values(?,?,?,?);