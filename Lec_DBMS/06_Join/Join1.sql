-- JOIN


-- FROM 절에 테이블에도 별칭 (alias)를 줄수 있다.
-- 20 레코드
SELECT s.STUDNO , s.NAME , s.DEPTNO1 
FROM T_STUDENT s; -- 여래개의 테이블을 join 할 경우, 테이블에게 별칭을 주는것이 좋다

-- 12 레코드
SELECT d.DEPTNO , d.DNAME 
FROM T_DEPARTMENT d;


-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 


-- 240 레코드
SELECT s.STUDNO , s.NAME , s.DEPTNO1 ,
	d.DEPTNO , d.DNAME 
FROM T_STUDENT s, T_DEPARTMENT d; -- 오라클 방식

SELECT s.STUDNO , s.NAME , s.DEPTNO1 ,
	d.DEPTNO , d.DNAME 
FROM T_STUDENT s
	CROSS JOIN T_DEPARTMENT d -- ANSI 방식
;


-- #6101
-- Equi Join (등가 Join) [ORACLE JOIN]
SELECT s.NAME "학생이름", s.DEPTNO1 "학과번호", d.DNAME "학과이름"
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO1 = d.DEPTNO ; -- 조건 (Equi Join)
	
-- Equi Join (등가 Join) [ANSI JOIN]
SELECT s.NAME "학생이름", s.DEPTNO1 "학과번호", d.DNAME "학과이름"
FROM T_STUDENT s JOIN T_DEPARTMENT d
ON s.DEPTNO1 = d.DEPTNO ; -- 조건 (Equi Join)


SELECT * FROM T_STUDENT ;

-- 제2전공은? deptno2
SELECT s.NAME "학생이름", s.DEPTNO2 "제2학과", d.DNAME "2제학과이름"
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO2 = d.DEPTNO ;

-- #6102
SELECT *
FROM T_STUDENT s , T_PROFESSOR p;

-- 오라클 방식
SELECT s.NAME "학생이름", s.PROFNO "지도교슈", p.NAME "지도교슈이름"
FROM T_STUDENT s , T_PROFESSOR p
WHERE s.PROFNO = p.PROFNO ;

-- ANSI 방식
SELECT s.NAME "학생이름", s.PROFNO "지도교슈", p.NAME "지도교슈이름"
FROM T_STUDENT s JOIN T_PROFESSOR p
ON s.PROFNO = p.PROFNO ;

-- #6103
-- ORACLE 방식
SELECT s.NAME "학생이름", d.DNAME "학과이름", p.NAME "교슈이름"
FROM T_STUDENT s, T_PROFESSOR p, T_DEPARTMENT d
WHERE s.DEPTNO1 = d.DEPTNO AND s.PROFNO = p.PROFNO ;

-- ANSI 방식
SELECT s.NAME "학생이름", d.DNAME "학과이름", p.NAME "교슈이름"
FROM 
	T_STUDENT s 
	JOIN T_DEPARTMENT d ON s.DEPTNO1 = d.DEPTNO 
	JOIN T_PROFESSOR p ON s.PROFNO = p.PROFNO ;
	

-- #6104
SELECT * FROM T_EMP2 ;
SELECT * FROM T_POST ;

SELECT e.NAME 사원이름, e.POST 현재, e.PAY 현재연봉, p.S_PAY 하한금액, p.E_PAY 상한금액
FROM 
	T_EMP2 e, T_POST p
WHERE e.POST = p.POST;

SELECT * FROM T_EMP2 ;
SELECT * FROM T_POST ;

SELECT e.NAME 사원이름, e.POST 현재, e.PAY 현재연봉, p.S_PAY 하한금액, p.E_PAY 상한금액
FROM 
	T_EMP2 e JOIN T_POST p
ON e.POST = p.POST;

-- #6105
SELECT * FROM T_STUDENT ;
SELECT * FROM T_PROFESSOR ;
	
SELECT s.NAME 학생이름, p.NAME 교수이름
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.DEPTNO1 = p.DEPTNO -- join 조건
AND s.DEPTNO1 = 101; -- 검색 조건

SELECT s.NAME 학생이름, p.NAME 교수이름
FROM T_STUDENT s JOIN T_PROFESSOR p ON s.DEPTNO1 = p.DEPTNO 
WHERE s.DEPTNO1 = 101;
