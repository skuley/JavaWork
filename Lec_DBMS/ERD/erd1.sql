
/* Drop Tables */

DROP TABLE register CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE professor
(
	profono number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	PRIMARY KEY (profono)
);


CREATE TABLE register
(
	studno number NOT NULL,
	subno number NOT NULL
);


CREATE TABLE student
(
	studno number NOT NULL,
	name varchar2(10) NOT NULL,
	deptno number,
	profono number NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE subject
(
	subno number NOT NULL,
	subname varchar2(10) NOT NULL,
	profono number NOT NULL,
	PRIMARY KEY (subno)
);



/* Create Foreign Keys */

ALTER TABLE student
	ADD FOREIGN KEY (profono)
	REFERENCES professor (profono)
;


ALTER TABLE subject
	ADD FOREIGN KEY (profono)
	REFERENCES professor (profono)
;


ALTER TABLE register
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;


ALTER TABLE register
	ADD FOREIGN KEY (subno)
	REFERENCES subject (subno)
;



