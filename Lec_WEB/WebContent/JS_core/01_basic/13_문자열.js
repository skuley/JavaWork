var str1, str2, str3;

str1 = "John";
str2 = new String("John"); // 비추~

console.log(str1);
console.log(str2.toString());

console.log(str1 == str2);
console.log(str1 === str2);

console.log(str1.length); // 문자의 개수

str2 = "Hello Java Web FrameWork";
console.log(str2);

// 문자열 리터럴 중간을 끊어서 작성할 경우...
str2 = "Hello Java W\
eb FrameWork";
console.log(str2);

// indexOf(), lastIndexOf(), search() : 문자열 안에서 문자열 찾기
// 찾은 위치 인덱스 리턴, 못찾으면 -1 리턴
console.log("문자열 검색 <br>indexOf(), lastIndexOf(), search()");
str1 = "Please locate where 'locate' occurs!";
console.log(str1.indexOf("locate"));
console.log(str1.lastIndexOf("locate")); 
console.log(str1.indexOf("John"));
console.log(str1.indexOf("locate", 10)); // 10번째부터 검색시작
console.log(str1.indexOf("locate", 25)); // 25번째부터 검색시작 --> 못 찾으면 -1

// search() : 문자열 안에서 문자열 찾기
console.log(str1.search("locate"));
// search() vs indexOf() : 둘은 다르다!
// 	search() : 두번째 매개변수 없다 (특정 패턴을 찾는것이 장점이다)
// 	indexOf() : regexp 사용 불가

console.log();

//문자열 추출
//slice(start, end)
//substring(start, end)
//substr(start, length)
console.log("문자열 추출\nslice(), substring(), substr()");
str1 = "Apple, Banana, Kiwi";

// slice()
console.log(str1.slice(7, 13)); // 7부터 13전까지
console.log(str1.slice(-12, -6));
console.log(str1.slice(-6, -12));
console.log(str1.slice(7));
console.log(str1.slice(-12));

// substring()
console.log(str1.substring(7, 13)); // slice()와 유사하나 음수인덱싱 지원 ㄴㄴ
console.log(str1.substring(7));

// substr()
console.log(str1.substr(7, 6)); // 7부터 6글자!
console.log(str1.substr(7));
console.log();


// 문자열 치환
// replace() : 치환한 결과 문자열 리턴, 정규표현식 사용 가능
// 기본적으로 첫번째 '매칭된 문자열 만 치환
console.log("문자열 치환 replace()");
str1 = "Please visit Japan!";

console.log(str1.replace("Japan", "Korea")); // 원본 str1 변경 안함.
console.log(str1.replace("JAPAN", "Korea")); // 정확하게 대소문자 구별하는것만 변경 됨!

console.log(str1.replace(/JAPAN/i, "Korea")); // 정규표현식 대소문자 구분없이 치환 (i)를 붙혀야 한다

str2 = "Please visit Japan! Go Japan";
console.log(str2.replace("Japan", "Korea")); // 기본적으로 첫번째만 치환됨

console.log(str2.replace(/Japan/g, "Korea")); // g : global match 정규표현식

console.log();

str3 = "Hellow World!";
console.log(str3.toUpperCase());
console.log(str3.toLowerCase());

str1 = "Hellow"; str2 = "World";
console.log(str1 + " " + str2);
console.log(str1.concat(" ", str2));

// trim() :  좌우 공백 제거
str1 = "       Hello World!       ";
console.log(`str1 = [${str1}]`);
console.log(`str1 = [${str1.trim()}]`);
console.log(`str1 = [${str1}]`); // trim 했다고 변하지는 않는다

// split() : string 쪼개서 -> 배열
str3 = '2020-05-07';
console.log(str3.split('-'));





