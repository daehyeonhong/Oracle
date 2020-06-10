--ex1 equi join scott사원의 부서번호,부서명
select dno,dname
from EMPLOYEE natural join department
where ename=upper('scott');
--ORA-00918: column ambiguously defined
select e.dno,dname
from EMPLOYEE e, DEPARTMENT d
where e.dno=d.dno
and ename=upper('scott');

--ex.2 inner join~on 사원명, 소속부서명,지역명
--on->조건
select ename,dname,loc
from EMPLOYEE e
inner join DEPARTMENT d
on e.dno=d.dno;
--using->속성
select ename,dname,loc
from EMPLOYEE e
inner join DEPARTMENT d
using(dno);

--ex.3 inner join~using
select eno,ename,job,loc
from EMPLOYEE e
inner join DEPARTMENT d
using(dno)
where dno=10;

--ex.4 natural join 이름,부서,지역
select ename,dname,loc
from EMPLOYEE
natural join department
where commission
is not null
and commission>0;

--ex5. equi join wildcard like '%',A,이름,부서명
select ename,dname
from EMPLOYEE e,DEPARTMENT d
where e.dno=d.dno
and e.ename like'%A%';

select ename,dname
from EMPLOYEE e natural join DEPARTMENT d
where e.ename like'%A%';

--ex6. natural join NEW YORK에 근무하는 사원명 ,업무 부서명
SELECT ENAME,JOB,DNAME
FROM DEPARTMENT NATURAL JOIN EMPLOYEE
WHERE LOC=UPPER('NEW YORK');

--EX7. SELF JOIN 사원명,관리자명,관리자번호
SELECT A.ENO"사원번호",A.ENAME"사원명",B.ENAME"매니저명",A.MANAGER"매니저번호"
FROM EMPLOYEE A,EMPLOYEE B
WHERE A.MANAGER=B.ENO;

SELECT A.ENO"사원번호",A.ENAME"사원명",B.ENAME"매니저명",A.MANAGER"매니저번호"
FROM EMPLOYEE A INNER JOIN EMPLOYEE B
ON A.MANAGER=B.ENO;

--EX8. OUTER JOIN,SELF JOIN 관리자가 없는 사원 포함, 사원번호 기준으로 내림차순
SELECT*
FROM EMPLOYEE
WHERE MANAGER
IS NULL; 

SELECT*
FROM EMPLOYEE
WHERE MANAGER
IS NOT NULL;

SELECT A.ENO,A.ENAME,A.MANAGER,B.ENAME
FROM EMPLOYEE A,EMPLOYEE B--SELF JOIN
WHERE A.MANAGER=B.ENO(+)--OUTER JOIN
ORDER BY A.ENO DESC;--내림차순 정렬

SELECT A.ENO,A.ENAME,A.MANAGER,B.ENAME
FROM EMPLOYEE A LEFT OUTER JOIN EMPLOYEE B--SELF JOIN
ON A.MANAGER=B.ENO--OUTER JOIN
ORDER BY A.ENO DESC;--내림차순 정렬

--EX9. SELF JOIN 지정한 사원명('SCOTT'),부서번호,지정한사원과 동일한 부서에서 근무하는 사원
SELECT A.ENAME"이름",A.ENO"부서번호",B.ENAME"동료"
FROM EMPLOYEE A,EMPLOYEE B
WHERE A.DNO=B.DNO
AND A.ENAME LIKE UPPER('SCOTT')--LIKE ->=
AND B.ENAME!=UPPER('SCOTT');--!=같지않다.

--EX10.SELF JOIN,WARD보다 늦게 입사한 사원명,입사일
SELECT ENAME,HIREDATE
FROM EMPLOYEE
WHERE ENAME
LIKE UPPER('WARD');

SELECT B.ENAME,B.HIREDATE
FROM EMPLOYEE A,EMPLOYEE B
WHERE A.ENAME=UPPER('WARD')
AND A.HIREDATE<B.HIREDATE
ORDER BY HIREDATE;

--EX11.SELF JOIN 관리자보다 먼저 입사한 모든 사원명,입사일
SELECT A.ENAME"사원명",A.HIREDATE"입사일",B.ENAME"매니저명",B.HIREDATE"매니저입사일"
FROM EMPLOYEE A,EMPLOYEE B
WHERE A.MANAGER=B.ENO
AND A.HIREDATE<B.HIREDATE;