/* Drop Tables */
DROP TABLE test_member CASCADE CONSTRAINTS;

/* Create Tables */
CREATE TABLE test_member
(
	mb_no NUMBER,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate DATE 
);

-- 시퀀스
DROP SEQUENCE test_member_seq;
CREATE SEQUENCE test_member_seq;

DELETE FROM TEST_MEMBER ;

SELECT * FROM TEST_MEMBER ;





