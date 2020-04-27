SELECT * FROM T_PROFESSOR ;
SELECT COUNT(*), COUNT(HPAGE ) FROM T_PROFESSOR ; 
SELECT COUNT(BONUS ), sum(BONUS ), avg(BONUS ) FROM T_PROFESSOR ; 
SELECT MAX(HIREDATE ), min(HIREDATE )  FROM T_EMP ;

-- null허용 컬럼의 그룹함수 적용시
-- nvl, nvl2 함수를 사용해야 함
SELECT AVG(BONUS ), avg(nvl(BONUS , 0)) FROM T_PROFESSOR ; 

-- t_professor 테이블에서 '학과별'로 교수들의 평균 보너스를 출력하세요
-- 불가능하다! select 절에 group 함수와 group 함수가 아닌 것과는 같이 출력 불가
/*SELECT DEPTNO , AVG(BONUS ) 
FROM T_PROFESSOR ;*/

SELECT DEPTNO , ROUND( AVG(nvl(BONUS, 0) ), 1) 보너스평균 
FROM T_PROFESSOR 
GROUP BY DEPTNO ;

-- #5101
SELECT DEPTNO , "POSITION" , AVG(PAY ) 평균급여 
FROM T_PROFESSOR 
GROUP BY DEPTNO ,"POSITION"  -- 1. 학과별 그룹핑, 2. 직급별 그룹핑
ORDER BY DEPTNO ASC , "POSITION" ASC ;

SELECT * FROM T_PROFESSOR ;

-- 부서별 평균급여를 출력하되, 평균급여가 450보다 많은 학과만 출력
SELECT DEPTNO , AVG(PAY ) 평균급여 
FROM T_PROFESSOR 
--WHERE avg(PAY ) > 450 -- 그룹함수는 WHERE 절에서 사용 할 수 없다
GROUP BY DEPTNO ;

SELECT DEPTNO , AVG(PAY ) 평균급여 
FROM T_PROFESSOR 
GROUP BY DEPTNO 
HAVING AVG(PAY ) > 300;


-- <SELECT 쿠리문 순서>
-- SELECT
-- FROM
-- WHERE
-- GROUP BY
-- HAVING
-- ORDER BY

-- #5102
SELECT * FROM T_EMP ;

SELECT MGR "매니저" , 
COUNT(MGR ) "직원수", 
sum(SAL ) "급여총액", 
avg( nvl(SAL , 0)) "급여평균", 
AVG(NVL(COMM , 0)) "교통비평균" 
FROM T_EMP 
GROUP BY MGR
HAVING MGR IS NOT NULL ;

--#5103
SELECT * FROM T_PROFESSOR ;

SELECT DEPTNO , 
COUNT(DEPTNO ) "총인원", 
AVG(SYSDATE - HIREDATE ) "근속평균",
AVG(PAY ) "급여평균",
AVG(NVL(BONUS , 0) ) "보너스평균" 
FROM T_PROFESSOR 
WHERE "POSITION" IN ('정교수', '조교수')
GROUP BY DEPTNO ;

-- #5104
SELECT * FROM T_PROFESSOR ;

SELECT DEPTNO1 "학과",
MAX(WEIGHT ) - Min(WEIGHT ) "최대몸무게차이"
FROM T_STUDENT 
GROUP BY DEPTNO1 ;

-- #5105
SELECT DEPTNO1 "학과",
MAX(WEIGHT ) - Min(WEIGHT ) "최대몸무게차이"
FROM T_STUDENT 
GROUP BY DEPTNO1 
HAVING MAX(WEIGHT ) - Min(WEIGHT ) >= 30;