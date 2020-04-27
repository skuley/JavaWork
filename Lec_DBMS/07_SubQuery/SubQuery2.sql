CREATE TABLE test_emp_a(
	emp_id NUMBER,
	emp_name varchar2(100)
);

CREATE TABLE test_emp_b(
	emp_id NUMBER,
	emp_name varchar2(100)
);

DELETE FROM TEST_EMP_A ;
DELETE FROM TEST_EMP_B ;

INSERT INTO TEST_EMP_A VALUES (101, '장윤성');
INSERT INTO TEST_EMP_B VALUES (201, '고유성');

SELECT * FROM TEST_EMP_A ;
SELECT * FROM TEST_EMP_B ;

-- 동시에 여러개 테이블에 INSERT 하기
-- 다중 테이블 INSERT 구문에 SubQuery 필요
INSERT ALL 
	INTO TEST_EMP_A VALUES (102, '조현주')
	INTO TEST_EMP_B VALUES (202, '최현주')
SELECT * FROM DUAL ;

-- SubQuery 로 INSERT 가능
INSERT INTO TEST_EMP_A (SELECT 400, '안성원' FROM DUAL );
INSERT INTO TEST_EMP_B (SELECT 500, '김성원' FROM DUAL );

-- 테이블 묻더 가기 (묻고 더블)
INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A);

-- 특정 컬러만 가져오고 싶을때
INSERT INTO TEST_EMP_B (emp_name) (SELECT emp_name FROM TEST_EMP_A );
