
/* Drop Tables */

DROP TABLE class CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE class
(
	studno number NOT NULL,
	subno number NOT NULL
);


CREATE TABLE department
(
	deptno number NOT NULL,
	phonenum varchar2(10),
	dept varchar2(10),
	deptname varchar2(10),
	PRIMARY KEY (deptno)
);


CREATE TABLE professor
(
	profno number NOT NULL,
	jumin nvarchar2(13),
	addr varchar2(30),
	name varchar2(10),
	post varchar2(10),
	phonenum varchar2(20),
	hiredate date,
	deptno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE student
(
	studno number NOT NULL,
	jumin varchar2(13) NOT NULL,
	name varchar2(10) NOT NULL,
	grade number,
	phonenum varchar2(10) NOT NULL,
	deptno number NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE subject
(
	subno number NOT NULL,
	subname varchar2(20) NOT NULL,
	credit number,
	subjectsize number,
	classroom varchar2(20),
	year date,
	profno number NOT NULL,
	PRIMARY KEY (subno)
);



/* Create Foreign Keys */

ALTER TABLE professor
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE student
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE subject
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE class
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;


ALTER TABLE class
	ADD FOREIGN KEY (subno)
	REFERENCES subject (subno)
;



