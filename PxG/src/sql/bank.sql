create table bank(
ano varchar2(15),
owner varchar2(20)not null,
balance number default 0,
password varchar2(20)not null,
signdate date default sysdate,
log number(1) default 0,
primary key(ano)
);
commit
SELECT ano AS 계좌번호, owner as 계좌주,balance as 잔고,password as 비밀번호,signdate as 가입일,logon as 로그인여부 from BANK;

drop table bank;
truncate table bank;
select*from bank;

insert into bank(ano,owner,balance,password) values(?,?,?,?);

select ano from BANK where ano='1986-247-62282';

INSERT INTO BANK(ANO,OWNER,BALANCE,PASSWORD)VALUES('감자','감자',5000.0,'감자');
UPDATE BANK SET OWNER='1',BALANCE=2,PASSWORD='3',LOGON=1 WHERE ANO='7253-200-64259';
UPDATE BANK SET OWNER,BALANCE,PASSWORD,LOGON VALUES('1',2,'3','0')WHERE ANO='7253-200-64259';
UPDATE BANK SET * WHERE ANO=7253-200-64259;
select*from bank where ano = '1';
insert into bank(ano,owner,balance,password)values('1','1',500000000,'1');
insert into bank(ano,owner,balance,password)values('2','2',500000000,'2');
UPDATE BANK SET BALANCE=1115000 WHERE ANO='1';
UPDATE BANK SET PASSWORD=1 WHERE ANO=1

select to_number('111-111-111') from dual;

select ano,to_number(replace(ano,translate(ano,'X0123456789.','X'),'')) from bank;

select regexp_replace(ano,'(-){1,}','')from bank where regexp_replace(ano,'(-){1,}','')='726726392901';