-- *******************
-- 제약조건 (Constraint)
-- *******************

-- 테이블 생성시 동시에 설정하기

-- 나중에 t_dept2.dcode 참초 예정
SELECT * FROM T_DEPT2 ;

-- #9001
-- 제약조건을 명시하지 않는 방법
-- cascade constraint : 제약조건도 같이 지운다
DROP TABLE t_emp3 CASCADE CONSTRAINT ;

CREATE TABLE t_emp3 (
	no NUMBER(4) PRIMARY KEY ,
	name VARCHAR2(10) NOT NULL ,
	jumin VARCHAR2(13)NOT NULL UNIQUE ,
	area NUMBER(1) CHECK (area < 5),
	deptno VARCHAR2(6) REFERENCES t_dept2(dcode)
);

-- 별도의 항목으로 제약조건 정의 가능
DROP TABLE t_emp4 CASCADE CONSTRAINT ;

CREATE TABLE t_emp4 (
	no NUMBER(4) ,
	name VARCHAR2(10) NOT NULL ,
	jumin VARCHAR2(13)NOT NULL ,
	area NUMBER(1) ,
	deptno VARCHAR2(6) , 
	PRIMARY KEY (no),
	UNIQUE (jumin),
	CHECK (area < 5),
	FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
);


-- #9002
-- 제약조건명을 명시하여 정의
DROP TABLE t_emp3 CASCADE CONSTRAINT ;

CREATE TABLE t_emp3 (
	no NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY ,
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL ,
	jumin VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL 
		CONSTRAINT emp3_jumin_uk UNIQUE ,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK (area < 5),
	deptno VARCHAR2(6) CONSTRAINT emp2_deptno_fk REFERENCES t_dept2(dcode)
);


DROP TABLE t_emp3 CASCADE CONSTRAINT ;

CREATE TABLE t_emp3 (
	no NUMBER(4) ,
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL ,
	jumin VARCHAR2(13) CONSTRAINT emp3_jumin_nn NOT NULL ,
	area NUMBER(1) ,
	deptno VARCHAR2(6) ,
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
);

-- #9003 제약조건 조회하기
SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP4'; -- 테이블명 대문자 

SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP3'; -- 테이블명 대문자 

-- #9005 : 제약조건에 맞는 / 위배되는 DML 시도해보기
INSERT INTO t_emp3 VALUES (1, '오라클', '1234561234567', 4, 1000); -- 두번 실행하면 오류
-- SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_NO_PK) violated 
-- number primary key
SELECT * FROM t_emp3;


INSERT INTO t_emp3 VALUES (2, '오라클', '1234561234567', 4, 1000); -- 실행하면 오류
-- SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated
-- jumin unique


INSERT INTO t_emp3 VALUES (2, '오라클', '2222222222222222', 4, 1000); -- 데이터 타입 오류
-- SQL Error [12899] [72000]: ORA-12899: value too large for column "SCOTT0316"."T_EMP3"."JUMIN" (actual: 16, maximum: 13)



INSERT INTO t_emp3 VALUES (2, '오라클', '2222222222222', 10, 1000); 
-- SQL Error [1438] [22003]: ORA-01438: value larger than specified precision allowed for this column


INSERT INTO t_emp3 VALUES (3, '오라클', '2322222222222', 3, 2000); 
-- SQL Error [2291] [23000]: ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found

INSERT INTO t_emp3 (NO, jumin, area, deptno) VALUES(3, '3333333333333', 4, 1001);
-- SQL Error [1400] [23000]: ORA-01400: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")

-- INSERT 뿐 아니라 UPDATE / DELETE 에서도 오류 발생 가능
UPDATE t_emp3 SET area = 10 WHERE NO = 1; -- CHECK 값 오류

SELECT * FROM t_emp3;
DELETE FROM t_dept2 WHERE DCODE = 1000; -- 참조하고 있는 부모 삭제 불가
-- SQL Error [2292] [23000]: ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - child record found


-- #9005
-- 테이블 생성 후에 ALTER 명령 사용하여 제약조건 추가 가능
-- ALTER ~ ADD
-- ALTER ~ MODIFY
-- ALTER ~ DROP
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk UNIQUE (name);


-- 제약조건 조회하기
SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP4'; -- 테이블명 대문자 


-- #9006
ALTER TABLE t_emp4 ADD CONSTRAINT empt_area_nn NOT NULL;
-- SQL Error [904] [42000]: ORA-00904: : invalid identifier

-- 이미 컬럼의 기본값은 null을 포함하고 잇기 때문에 add가 아닌 modify로 가야한다
ALTER TABLE t_emp4 MODIFY (area CONSTRAINT emp4_area_nn NOT NULL);

-- #9007
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);
-- SQL Error [2270] [42000]: ORA-02270: no matching unique or primary key for this column-list
-- 참조되는 부모테이블의 컬럼은 primary key 이거나 unique 해야한다

-- 부모 테이블의 name을 unique 로 바꾼뒤 위의 쿼리를 다시 실행해보자
ALTER TABLE T_EMP2 ADD CONSTRAINT emp2_name_uk unique(name);


-- #9008
DROP TABLE t_emp3 CASCADE CONSTRAINT ;

CREATE TABLE t_emp3 (
	no NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY ,
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL ,
	jumin VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL 
		CONSTRAINT emp3_jumin_uk UNIQUE ,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK (area < 5),
	deptno VARCHAR2(6) 
		CONSTRAINT emp2_deptno_fk REFERENCES t_dept2(dcode)
		ON DELETE CASCADE -- 부모 삭제되면 자식도 같이 삭제됨
		--ON DELETE SET NULL -- 부모 삭제되면 null 값으로 바뀐다
);

-- 제약조건 조회하기
SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP3'; -- 테이블명 대문자 


-- #9009
-- alter 로 name필드 제약조건에
-- 부모테이블이 삭제되면 NULL이 되도록 설정하기 (ALTER 사용)
ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk; -- 일단 기존 제약조건 삭제

ALTER TABLE t_emp4 
ADD CONSTRAINT emp4_name_fk  FOREIGN KEY (name)
	REFERENCES t_emp2(name)
	ON DELETE SET NULL ; -- 부모 삭제되면 자식은 null로 남아 있겠습니다
	
-- 제약조건 조회하기
SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_EMP4'; -- 테이블명 대문자 

--------------------------------------------------------------------------

-- DISABLE NOVALIDATE
SELECT * FROM T_NOVALIDATE ;
SELECT * FROM T_VALIDATE ;

SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_VALIDATE';

SELECT OWNER , CONSTRAINT_NAME , CONSTRAINT_TYPE , STATUS 
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'T_NOVALIDATE';

INSERT INTO T_VALIDATE VALUES (1, 'DDD');
-- SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.TV_NO_PK) violated //// primary key니까

INSERT INTO T_NOVALIDATE VALUES (1, 'DDD');
-- SQL Error [1] [23000]: ORA-00001: unique constraint (SCOTT0316.SYS_C007074) violated

ALTER TABLE T_NOVALIDATE 
disable novalidate CONSTRAINT SYS_C007074;

SELECT * FROM T_NOVALIDATE ;

ALTER TABLE T_NOVALIDATE 
ENABLE NOVALIDATE CONSTRAINT SYS_C007074;

DELETE FROM T_NOVALIDATE WHERE name = 'DDD';












