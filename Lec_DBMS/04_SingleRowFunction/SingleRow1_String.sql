--INITCAP() 함수


-- #4101
SELECT INITCAP('pretty girl') 
FROM DUAL;

-- #4102
SELECT INITCAP(ID) ID -- t_student 에 있는 id를  INITCAP()함수를 적어 첫번째 문자를 대문자로 변환
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- #4103
SELECT NAME , ID , LOWER(ID) 소문자 , UPPER(ID) 대문자
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- #4104
SELECT NAME 이름 , ID , LENGTH (ID) 글자수
FROM T_STUDENT 
WHERE LENGTH (ID) >= 9

-- #4105
SELECT name 이름, LENGTH(NAME) 길이, LENGTHB(NAME) 바이트 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

-- #4106
SELECT CONCAT(NAME , "POSITION" ) 교수님명단
FROM T_PROFESSOR 
WHERE DEPTNO = 101 ; 

-- #4107
SELECT SUBSTR('ABCDE', -2, 1) 
FROM DUAL ;

SELECT NAME 이름, SUBSTR(JUMIN, 1 , 6 ) 생년월일 
FROM T_STUDENT
WHERE DEPTNO1 = 101; 

-- #4108
SELECT NAME 이름, SUBSTR(JUMIN , 1 , 6) 생년월일 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN , 4, 1) = '8' ;

-- #4109
SELECT NAME , JUMIN 
FROM T_STUDENT
WHERE SUBSTR(JUMIN , 7, 1) = '2' AND GRADE = 4; 

-- INSTR() 함수
SELECT  INSTR('A*B*C*', '*', 1, 1) AS instr -- 찾는 문자열의 첫번째 위치를 찾는데 마지막 매개변수
FROM DUAL ;

SELECT  INSTR('A*B*C*', '*', 1, 2)
FROM DUAL ;

SELECT  INSTR('A*B*C*', '*', 3, 2)
FROM DUAL ;

-- 음수면 음의 방향으로 검색 진행
SELECT  INSTR('A*B*C*', '*', -4, 1) 
FROM DUAL ;

--- 없으면 0을 리턴한다
SELECT  INSTR('A*B*C*', '*', -4, 2) 
FROM DUAL ;

SELECT  INSTR('A*B*C*', '*', -2, 2) 
FROM DUAL ;


-- #4110
SELECT NAME,  TEL , INSTR(tel, ')') 위치 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4111
SELECT NAME , TEL , SUBSTR(TEL , 1, INSTR(TEL ,')') - 1) AS 지역번호 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- LTRIM() 함수 & RTRIM() 함수
SELECT 
	LTRIM('슈퍼슈퍼슈가맨', '슈퍼') LTRIM ,
	LTRIM('슈퍼슈퍼슈가맨', '퍼') LTRIM,
	LTRIM('     슈퍼슈퍼슈가맨', ' ') LTRIM, 
	LTRIM('     슈퍼슈퍼슈가맨') LTRIM ,  -- 좌우 공백 제거
	RTRIM('우측공백제거      ') RTRIM ,
	LTRIM('*************10000', '*')LTRIM 
FROM DUAL ;

-- #4117
SELECT * FROM T_DEPT2 ;

SELECT DNAME , RTRIM(DNAME, '부') RTRIM예제
FROM T_DEPT2 ;

-- REPLACE 함수
SELECT REPLACE ('슈퍼맨 슈퍼걸', '슈퍼', '파워')
FROM dual;

SELECT REPLACE ('아버지가 방에 들어간다', ' ', '')
FROM DUAL ;

-- #4118
SELECT REPLACE (NAME, SUBSTR(NAME , 1, 1), '#') 학생
FROM T_STUDENT
WHERE DEPTNO1 = 102;

-- #4119
SELECT REPLACE (NAME , SUBSTR(NAME , 2, 1), '#') 학생
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4120
SELECT NAME , REPLACE (JUMIN , SUBSTR(JUMIN , 7, 7) ,'*******' ) 주민번호
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#4121
SELECT NAME , TEL , REPLACE (TEL , SUBSTR(TEL , INSTR(TEL , ')') + 1, 3), '###') 전화번호 
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

















