/* object 의 getter, setter

getter 함수: 특정 값을 조회할때마다
setter 함수: 특정 값을 설정할때마다

https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/get

ES 5.1 에 최초 정의
https://www.ecma-international.org/ecma-262/5.1/#sec-11.1.5

ES 6 에서 계산된 프로퍼티 이름이 추가
https://www.ecma-international.org/ecma-262/6.0/#sec-method-definitions


JS 에서 매우 유용

*/


const numbers = {
    a: 1,
    b: 2,
    
    // getter 함수
    get sum(){
        // get 키워드로 시작
        console.log("sum 함수가 실행됩니다");
        return this.a + this.b;
        // return이 빠지면 undefined 리턴
    }
}

// getter 함수는 아래와 같이 '조회' 하려할때
// 함수가 호출, 실행됩니다.
//numbers.sum();
console.log(numbers.sum);
// numbers.sum;

numbers.b = 5;
console.log(numbers.sum);


// setter 함수
const dog = {
    _name : 'doggy',

    // setter
    // set keyword로 시작
    set name(value){
        // 반드시 parameter가 설정되어야 한다
        console.log('이름이 바뀝니다...' + value);
        this._name = value;
    }
}

console.log('-------------------------');
console.log(dog._name);
// console.log(dog.name('puppy')); 
dog.name = 'puppy';
console.log(dog._name);

console.log('-------------------------');

const numbers2 = {
    _a : 1,
    _b : 2,
    sum : function(){
        return this._a + this._b;
    }
}

console.log(numbers2.sum());
numbers2._a = 10;
numbers2._b = 20;
console.log(numbers2.sum());

const numbers3 = {
    _a : 1,
    _b : 2,
    sum : 3,

    get a(){ return this._a},
    get b(){ return this._b},
    set a(value){
        this._a = value;
        this.sum = this._a + this._b;
    },
    set a(value){
        this._a = value;
        this.sum = this._a + this._b;
    },
    set b(value){
        this._a = value;
        this.sum = this._a + this._b;
    }

}

console.log('------------------------------');
console.log(numbers3.sum);
numbers3.a = 10;
numbers3.b = 20;
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);


