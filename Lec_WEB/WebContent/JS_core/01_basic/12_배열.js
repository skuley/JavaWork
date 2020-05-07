// 배열 생성 방법

// 방법1 : [] 사용
var points = [40, 100, 1, 5, 25, 10];
var fruits = ['Banana', 'Orange', 'Apple', 'Mango'];

console.log('points = ', points, typeof points);

// 방법2 : new 사용
var cars = new Array("Saab", "Volvo", "BMW"); // 비추
console.log('cars = ', cars, typeof cars);

console.log('fruits = ', fruits.toString());

console.log();

// JS에선 object 의 property 접근 횟수를 줄이는게 성능에 유리
for(i = 0; i < cars.length; i++){
    console.log(cars[i]);
    
}

console.log();

// 위의 경우보다 좋은 성능
var length = cars.length;
for(i = 0; i < length; i++){
    console.log(cars[i]);
    
}

console.log();

// for ~ in : 객체(object) 에 대해 사용, property
for(x in cars){ // value 가 아닌 index가 나옴
    console.log('x = ', x, typeof x);
    
}

console.log();

// for ~ of : ES6 부터 사용
for(x of cars){
    console.log('x = ', x, typeof x);
    
}

console.log();

// 배열.forEach(함수)
// 배열 원소 하나하나 뽑아내면서 함수 호출
var myFunction = function(value){
    console.log(value);
    
}

cars.forEach(myFunction);

// 배열원소 추가
console.log();
fruits[fruits.length] = 'Melon';
console.log(fruits);
console.log();

fruits.push('Lemon');
console.log(fruits);