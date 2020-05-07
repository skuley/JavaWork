// function 함수이름 (매개변수...)

function add(a, b){
    return a + b;
}

var sum = add(1,2);
console.log('sum = ', sum);

// JS 에선 '함수(fucntion)' 도 데이터 다!!!
console.log(typeof add);
console.log(add);

// 함수를 변수에 대입할수도 있고
// 함수를 매개변수로 넘겨줄수도 있고
// 함수를 리턴할수도 있다.
// ------------------------------------------

// JS 는 함수 정의시 아래와 같은 표현을 더 선호함
// 이름 없는 함수 사용
var sub = function(a, b){
    return a - b;
}

console.log(sub(10, 3));

let mul = function(a, b){
    return a * b;
}

console.log(mul(10, 3), typeof mul);

let bbb = mul;
console.log(bbb(100, 2));

var arr = [add, sub, mul];

console.log(arr[0](10, 20));
console.log(arr[1](10, 20));
console.log(arr[2](10, 20));



