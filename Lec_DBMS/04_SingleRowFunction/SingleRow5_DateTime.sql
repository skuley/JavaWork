-- 날짜 함수
SELECT SYSDATE FROM DUAL ; 

-- 기본적인 날짜 연산
SELECT 
	SYSDATE "오늘",
	SYSDATE + 1 "24시간뒤 내일" ,
	SYSDATE -2 "그저께" ,
	SYSDATE + 1/24 "한시간뒤" 
FROM DUAL ;

-- 일차 차이 계산
SELECT 
	SYSDATE "오늘",
	TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') 시작한날,
	SYSDATE -  TO_DATE('2020-03-16 09:00:00', 'YYYY-MM-DD hh:mi:ss') 경과
FROM DUAL ;

-- MONTHS_BETWEEN : 날짜 사이의 개월수
SELECT 
	-- 규칙1 : 두 날짜중 큰 날짜를 먼저 써야 양수값으로 나옴
	MONTHS_BETWEEN('2012-03-01', '2012-01-01') "양수값",
	MONTHS_BETWEEN('2012-01-01', '2012-03-01') "음수값",
	-- 규칙2 : 두 날짜가 같은 달에 속해 있으면 특정 규칙으로 계산된 값
	MONTHS_BETWEEN('2012-02-29', '2012-02-01') "2/29 ~ 2/01",
	MONTHS_BETWEEN('2012-04-30', '2012-04-01') "4/30 ~ 4/01",
	MONTHS_BETWEEN('2012-05-31', '2012-05-01') "5/31 ~ 5/01"
FROM DUAL ;

-- #4501
SELECT NAME AS 이름, 
SYSDATE AS 오늘, 
HIREDATE AS 입사일, 
TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE , 'YYYY') AS 근속연수,
ROUND(MONTHS_BETWEEN(SYSDATE , HIREDATE ), 1) "근속개월",
ROUND(SYSDATE - HIREDATE , 1) "근속일" 
FROM T_PROFESSOR ;

-- ADD_MONTH() 개월 추가 함수
SELECT 
SYSDATE, ADD_MONTHS(SYSDATE, 3 ) 
FROM DUAL ;

SELECT 
SYSDATE,
LAST_DAY(SYSDATE) "이번달 마지막날",
NEXT_DAY(SYSDATE, '월') "다음 월요일" 
FROM DUAL ;

-- 날짜의 ROUND() 함수  ,  하루의 반은 정오 12:00:00 이다. 이를 넘어서면 다음 날짜
-- 날짜의 TRUNC() 함수,  무조건 당일 출력.
-- 원서 접수나 상품 주문 등에서 오전까지 접수된 건은 당일 접수 처리. 오후접수는 익일 처리 등에서 사용.

SELECT 
	SYSDATE,
	ROUND(SYSDATE ),
	trunc(SYSDATE)
FROM DUAL ;