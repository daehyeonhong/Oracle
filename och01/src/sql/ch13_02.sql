-- ex01. kbs라는 사용자 생성 암호는 pass
create user kbs identified by pass
default tablespace users
temporary tablespace temp
quota unlimited on users;

-- ex02. connect, resource
grant connect, resource to kbs;

-- ex03.