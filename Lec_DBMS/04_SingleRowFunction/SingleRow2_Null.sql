SELECT * FROM T_PROFESSOR ;

-- null값과의 모든 연산 결과는 NULL 이다!
SELECT NAME , PAY + BONUS 
FROM T_PROFESSOR ;

-- 그룹함수에서는 동작 / null은 연산에서 제외되어 동작
SELECT sum(PAY ), sum(BONUS )
FROM T_PROFESSOR; 

-- nvl() 함수
SELECT NAME , PAY, BONUS ,
	PAY + BONUS 총지급액,
	PAY + NVL(BONUS , 0) 총지급액
FROM T_PROFESSOR ;

-- #4201	
-- NVL2(BONUS , BONUS, 0) 
SELECT NAME , PAY , NVL2(BONUS, BONUS , 0) BONUS , 
NVL2(BONUS , PAY * 12 + BONUS , PAY  * 12) 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO = 101;