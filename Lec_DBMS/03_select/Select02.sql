-- 드라이버는 최초 한번 해줘야한다
-- connection은 프로젝트 단위로 잡아줘야한다

--------------------------------------

-- 산술 연산자
SELECT ENAME , SAL , SAL * 1.1 -- 급여 10% 인상분
FROM T_EMP ;

SELECT ENAME , SAL , COMM , SAL + COMM -- null값과의 산술연산은 무.조.건   !!NULL!!
FROM T_EMP ;

-- WHERE 조건절
SELECT * FROM T_EMP WHERE job='SALESMAN'; -- 문자는 대소문자 구분 한다!!

SELECT ENAME , DEPTNO 
FROM T_EMP WHERE DEPTNO = 10;

SELECT ENAME , SAL 
FROM T_EMP 
WHERE SAL > 2000;

SELECT ENAME , EMPNO , SAL 
FROM T_EMP 
WHERE ENAME = 'SCOTT';

-- 연습
-- 학생 테이블 (t_student) 에서
-- 2,3학년 (grade) 학생의 이름(name), 학년(grade), 출력

SELECT * FROM T_STUDENT ;

SELECT NAME , GRADE 
FROM T_STUDENT 
WHERE GRADE = 2 OR grade = 3 ;

SELECT NAME , GRADE 
FROM T_STUDENT 
WHERE GRADE IN (2, 3);

SELECT NAME , GRADE 
FROM T_STUDENT 
WHERE GRADE > 1 AND grade < 4;

SELECT NAME , GRADE 
FROM T_STUDENT 
WHERE GRADE NOT IN (1, 4);

SELECT NAME , GRADE 
FROM T_STUDENT 
WHERE GRADE BETWEEN 2 AND 3;

SELECT NAME , PAY , "POSITION" 
FROM T_PROFESSOR 
WHERE pay > 300 AND "POSITION" = '정교수';

SELECT NAME , "POSITION" 
FROM T_PROFESSOR 
WHERE BONUS IS NULL;

-- LIKE 연산자
SELECT NAME 
FROM T_PROFESSOR 
WHERE name LIKE '김%';

SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '%NE%';

-- '_A' : 반드시 _에 하나의 문자가 들어와야한다
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '_A%';

-- ORDER BY
-- 직원중 이름에 L이 들어간 사람의 일므을 사전 내림차순으로 출력하기
SELECT ename FROM T_EMP WHERE ename LIKE '%L%'
ORDER BY ENAME DESC ;

SELECT ENAME , JOB , SAL 
FROM T_EMP 
ORDER BY JOB DESC , SAL ASC ;

SELECT NAME , GRADE, HEIGHT 
FROM T_STUDENT 
ORDER BY GRADE ASC, HEIGHT DESC;



