CREATE OR REPLACE VIEW v_pro
AS 
SELECT PROFNO , NAME , EMAIL , HPAGE 
FROM T_PROFESSOR ;

SELECT * FROM v_pro;

SELECT tname FROM tab; -- VIEW 확인 가능

-- View 생성시 별도의 컬럼이름을 지정해줄수 있다
CREATE OR REPLACE VIEW v_pro (pfno, nm, em, hp)
AS 
SELECT PROFNO , NAME , EMAIL , HPAGE 
FROM T_PROFESSOR ;

SELECT * FROM v_pro;

-- #8102
CREATE VIEW v_prof_dept(교수번호, 교수명, 소속학과명)
AS 
SELECT p.PROFNO , p.NAME , d.DNAME 
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO ;

SELECT * FROM v_prof_dept;

-- #8103
SELECT 
	d.DNAME "학과명",
	s.max_height "최대키",
	s.max_height "최대몸무게"
FROM 
	(SELECT DEPTNO1 , MAX(HEIGHT ) max_height, MAX(WEIGHT ) max_weight 
	FROM T_STUDENT 
	GROUP BY DEPTNO1 ) s ,
	t_department d
WHERE s.deptno = d.DEPTNO ;

SELECT 
	d.dname "학과명", 
	s.max_height "최대키", 
	s.max_weight "최대몸무게"
FROM 
	( SELECT deptno1, MAX(height) max_height, MAX(weight) max_weight
	FROM t_student
	GROUP BY deptno1 ) s , 
	t_department d
WHERE 
	s.deptno1 = d.deptno;

-- #8104
SELECT d.DNAME "학과명", a.max_height "최대키", s.NAME "학생이름", s.HEIGHT "키"
FROM 
	(SELECT DEPTNO1 , MAX(HEIGHT ) max_height FROM T_STUDENT GROUP BY DEPTNO1 ) a,
	t_student s, t_department d
WHERE 
	s.DEPTNO1 = a.deptno1 AND s.HEIGHT = a.max_height
	AND s.DEPTNO1 = d.DEPTNO ;

-- #8105
-- 학년별 평균 키

SELECT 
	s.GRADE "학년",
	s.NAME "이름",
	s.HEIGHT "키",
	a.avg_height "평균키"
FROM 
	(SELECT GRADE , AVG(HEIGHT ) avg_height FROM T_STUDENT GROUP BY GRADE ) a,
	t_student s
WHERE 
	a.grade = s.GRADE AND s.HEIGHT > a.avg_height
ORDER BY 1;
;
















