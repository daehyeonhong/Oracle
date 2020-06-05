drop table sale;
drop table bucket;
drop table stock;

create table stock(
item varchar2(200)primary key,
qty number not null
);
create table bucket(
item varchar2(200) not null,
qty number not null
);
create table sale(
id varchar2(20)primary key,
item varchar2(200) not null,
qty number not null
);

insert into STOCK values('감자',50);
insert into BUCKET values('감자',50)where 