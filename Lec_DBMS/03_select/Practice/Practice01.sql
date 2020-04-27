CREATE TABLE practice (
	words VARCHAR2(2),
	numbr NUMBER(2)
);

ALTER TABLE PRACTICE MODIFY (
words VARCHAR2(30),
numbr NUMBER
);

SELECT * FROM PRACTICE ;

INSERT INTO PRACTICE VALUES ('h', 20);
INSERT INTO PRACTICE VALUES ('h', 2000000);

SELECT * FROM T_EMP ;
SELECT * FROM T_EMP2 ;

/*ALTER TABLE PHONEBOOK 
MODIFY (
	pb_name VARCHAR2(1)
);*/

SELECT NAME AS "학생 이름"
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

SELECT DISTINCT DEPTNO FROM T_EMP ;

SELECT * FROM T_STUDENT ;
SELECT * FROM T_PROFESSOR ;

SELECT s.NAME || ' : ' || p.NAME AS "학생과 교수"
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.PROFNO = p.PROFNO ;

SELECT NAME 
FROM T_STUDENT
WHERE NAME LIKE '%미%';

SELECT NAME 
FROM T_STUDENT; 

CREATE TABLE res_category(
	KOR NUMBER(1),
	JJANG NUMBER(1),
	YANG NUMBER(1)
);

INSERT INTO RES_CATEGORY values(1,2,3);
DROP TABLE RES_CATEGORY CASCADE CONSTRAINT;
SELECT * FROM RES_CATEGORY ;

CREATE TABLE restaurants(
	res_name VARCHAR2(10),
	category VARCHAR2(10),
	menu CLOB,
	price NUMBER,
	addr VARCHAR2(30)
);

SELECT * FROM restaurants;

ALTER TABLE restaurants add(
	imgaddr VARCHAR2(100)
);

--교수님 중에서 급여를 5000 이상 받는 분들의

--‘이름’ 과 ‘급여’ 를 출력하는 SQL문을 작성하세요.
SELECT NAME "이름", PAY "급여"
FROM T_PROFESSOR 
WHERE pay > 5000;
SELECT * FROM T_PROFESSOR ;

-- 학생의 '이름'에 대한 검색 성능 향상을 위해
-- idx_student_name 라는 이름의 인덱스를 생성하는 SQL 문을 작성하세요
CREATE UNIQUE INDEX idx_student_name ON T_STUDENT(NAME);

	
--| 교수님 이름 | 소속 학과명 |   ← 이렇게 출력될수 있도록 SQL 문을 작성하세요
--* 별칭 도 작성해 주세요

SELECT 
NAME ,DEPTNO 
FROM T_PROFESSOR;

SELECT NAME "교수님 이름" ,DEPTNO "소속 학과명" FROM T_PROFESSOR;

SELECT p.NAME "교수님 이름" ,d.DEPTNO "소속 학과명"
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO ;


	
/*이윤나 학생의 학과와 동일한 학과의 학생들의
 | 학생이름 | 학과명 |   이 출력될수 있도록 SQL 문을 작성하세요.
* 별칭 도 작성해주세요*/

SELECT a.NAME "학생이름", d.DNAME "학과명"
FROM (SELECT DEPTNO FROM T_STUDENT WHERE NAME = '이윤나') a, T_DEPARTMENT d
WHERE a.deptno = d.DEPTNO ;

SELECT DEPTNO FROM T_STUDENT WHERE NAME = '이윤나';

SELECT s.NAME "학생이름", d.DNAME "학과명"
FROM T_STUDENT s JOIN T_DEPARTMENT d
ON  s.DEPTNO1 = d.DEPTNO AND s.NAME = '이윤나';

--T_STUDENT.PROFNO  → T_PROFESSOR.PROFNO 참조

--T_STUDENT.DEPTNO  → T_DEPARTMENT.DEPTNO 참조

--T_PROFESSOR.DEPTNO  → T_DEPARTMENT.DEPTNO 참조


CREATE OR REPLACE VIEW v_stud_info 
AS SELECT s.NAME , d.DNAME , p.NAME 
from T_STUDENT s, T_PROFESSOR p, T_DEPARTMENT d
WHERE s.DEPTNO1 = p.DEPTNO AND d.DEPTNO = p.DEPTNO ;









