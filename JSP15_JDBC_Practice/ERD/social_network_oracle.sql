
/* Drop Tables */

DROP TABLE sns_table CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE sns_table
(
	sns_uid number NOT NULL,
	sns_name varchar2(40) NOT NULL,
	sns_post clob NOT NULL,
	sns_regdate date DEFAULT SYSDATE,
	sns_viewcnt number DEFAULT 0,
	PRIMARY KEY (sns_uid)
);

CREATE SEQUENCE SNS_TABLE_SEQ;

SELECT * FROM sns_table;

INSERT INTO sns_table VALUES
(SNS_TABLE_SEQ.nextval, 'Scott', 'Welcome to our sns', sysdate, 0);



