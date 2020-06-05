create table bank(
ano varchar2(15),
owner varchar2(20)not null,
balance number default 0,
password varchar2(20)not null,
signdate date default sysdate,
logon number(1) default 0,
primary key(ano)
);
SELECT ano AS 계좌번호, owner as 계좌주,balance as 잔고,password as 비밀번호,signdate as 가입일,logon as 로그인여부 from BANK;

[출처] 2020.04.16.(오라클 함수, 데이터 항목 별칭 지정)|작성자 방지원
drop table bank;
truncate table bank;
select*from bank;

insert into bank(ano,owner,balance,password) values(?,?,?,?);