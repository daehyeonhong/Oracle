select*from CUSTOMER7;
select*from PRODUCT2;
select*from ORDERS;
select*from user_tables where table_name like'PRODU%';

--주문 테이블에 값 입력.
--ORA-02291: integrity constraint (HR.FK_PRODUCT2_TO_ORDERS) violated - parent key not found
insert into ORDERS values(1,10,1,sysdate,'hong','P1212');
--부모 테이블의 기본 키 값 등록(도메인)
insert into CUSTOMER7 values('hong','홍길동','1234','서울시','010-111-1234',sysdate);
insert into CUSTOMER7 values('kim','홍길동','1234','서울시','010-111-1234',sysdate);
--부모 테이블의 기본 키 값 등록(도메인)
--비 식별관계 -부모 테이블의 기본 키가 자식 테이블의 일반 속성으로 참조되는 관게(키가 아님)
insert into PRODUCT2 values('P1212','새우깡',2000,2300,10,sysdate);
SELECT*FROM ORDERS2;
SELECT*FROM CUSTOMER8;
SELECT*FROM PRODUCT3;

insert into ORDERS2 values(1,10,1,sysdate,'hong','P1212');
insert into CUSTOMER8 values('hong','홍길동','1234','서울시','010-111-1234',sysdate);
insert into PRODUCT3 values('P1212','새우깡',2000,2300,10,sysdate);

--ORDERS 테이블에 'HONG',['P1212'가 키
--식별관계-부모테이블의 기본 키가 자식 테이블의 속성으로 참조되는 경우
--참조되는 속성이 자식 테이블의 기본 키로 사용되는 경우 식별 관계임.
--ORA-00001: unique constraint (HR.PK_ORDERS2) violated
INSERT INTO ORDERS2 VALUES('hong','P1212',5,1,SYSDATE);
SELECT*FROM ORDERS2;