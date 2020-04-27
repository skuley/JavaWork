-- dual : ROW 1개 짜리 dummy TABLE;
SELECT 'abcde' FROM DUAL;
SELECT '안녕하세요' FROM DUAL ;
SELECT 100 FROM DUAL ;
SELECT 100 + 10 FROM DUAL;

-- * : 모든 컬럼
SELECT * FROM T_EMP;

-- 원하는 컬럼만 조회하기
SELECT EMPNO , ENAME 
FROM T_EMP ;

SELECT * FROM T_PROFESSOR ;

SELECT BONUS WHERE bonus IS NOT NULL 
FROM T_PROFESSOR ;

-- 한글이 지원 안돼 한글자만 나온다
SELECT '안녕하세요' FROM T_PROFESSOR ;

SELECT name, '교수 사랑해요' FROM T_PROFESSOR ;

-- 컬럼에 별명(alias) 사용한 출력
SELECT STUDNO 학번, NAME 이름
FROM T_STUDENT ;

-- 이름이라는 별명을 넣어줄수 있다
SELECT studno , NAME AS 이름
FROM T_STUDENT ;

-- 쌍따옴표로도 넣어줄수 있다
SELECT STUDNO "학번", NAME 
FROM T_STUDENT ;

SELECT STUDNO "학생 학번", NAME 
FROM T_STUDENT ;

SELECT EMPNO "사원번호", ENAME "사원명", JOB AS 직업
FROM T_EMP ;

SELECT DEPTNO "부서#", DNAME 부서명, LOC 위치
FROM T_DEPT ;

-- DISTINCT - 
SELECT * FROM T_EMP ;

SELECT deptno
FROM T_EMP ;

SELECT DISTINCT deptno
FROM T_EMP ;

-- t_student
SELECT DEPTNO1 
FROM T_STUDENT ;

SELECT DISTINCT DEPTNO1 
FROM T_STUDENT ;

-- t_emp
SELECT JOB 
FROM T_EMP ;

SELECT DISTINCT job
FROM T_EMP ;


-- || : 필드, 문자열 연결 연산
SELECT NAME, POSITION 
FROM T_PROFESSOR ;

SELECT NAME || '-' || POSITION AS 교수님명단
FROM T_PROFESSOR ;

SELECT * FROM T_PROFESSOR ;

-------------------------------------
SELECT * FROM T_STUDENT ;

SELECT NAME || '의 키는' || 
	HEIGHT || 'cm. 몸무게는 ' || 
	WEIGHT || '입니다' AS "학생의 키와 몸무게"
FROM T_STUDENT ;

