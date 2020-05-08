// object
console.log('object');

// property : value 쌍
x = {firstName: "John", lastName: "Doe"};

console.log(x, typeof x);

y = [10, 20, 30];
console.log(y, typeof y);

// value 접근하는 방법
console.log(x['firstName'], x.firstName);

// console.log(x[firstName]); // x --> firstName이라는 변수값을 찾는다

console.log(typeof x.firstName);

// object는 length값이 없다
console.log(x.length);

// for ~ in
// object 는 property 값을 추출되고 배열은 index값을 리턴한다
for(key in x){ // property 가 추출됨
    console.log(`x[${key}] = ${x[key]}`);
}

// value 는 어떠한 타입이라도 가능!!
x = {
    name : "kim"
    , age : 34
    , height : 172.3
    , score : [94, 35, 79]
    , sayHello : function(){
        console.log("안녕하세요");
    }
    , getScore : function(n){
        return this.score[n]; // this 빼면 에러!.   동일 object 의 property 접근할때 this 사용!
    }
    , getTotal : function(){
        var total = 0;
        for(i = 0; i < this.score.length; i++){
            total += this.score[i];
        }

        return total;
    }
    , getAvg : function(){
        var avg = this.getTotal() / this.score.length;
        return avg.toFixed(2); // 소수점 두자리수
    }
};


console.log(x['name'], typeof x['name']);
// console.log(x.name);
console.log(x['age'], typeof x['age']);
console.log(x['height'], typeof x['height']);
console.log(x.score, typeof x.score, x.score.length);
x.sayHello();
console.log(x.getScore(0));
console.log(x.getTotal()); // score 접수 합계
console.log(x.getAvg(), typeof x.getAvg()); // score 점수 평균

console.log();

// p:v 추가 변경 삭제
x = {firstName: "John", lastName: "Doe"};
console.log(x);

x.firstName = "Mike"; // 변경
console.log(x);

x.age = 45;
console.log(x); // 추가

delete x.firstName;
console.log(x);

// 없는 property 접근하려 하면
console.log(x.firstName);

// ----------------------------------------------
//console.log(a); // 에러
var b;
console.log(b);
b = '김재현';
console.log(b);

// ---------------------------------

// 함수가 object 생성자로 사용 가능 (원래는 함수가 object)
function Person(firstName, lastName, age){
    // 함수 안에서 this?????
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;

    // console.log(this);
    
}

Person('aaa', 'bbb', 43); // 호출

var p1 = new Person('aaa', 'bbb', 43);
console.log(p1);

var p2 = new Person('김', '재현', 25);
console.log(p2);

// window c = 'hong';


