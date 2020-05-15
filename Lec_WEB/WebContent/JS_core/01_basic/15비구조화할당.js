const ironman = {
    name: 'Tony Stark',
    actor: 'Robert Downey',
    alias: 'Iron Man'
};

const captain = {
    name: 'Steve Rogers',
    actor: 'Chris Evans',
    alias: "Captain",
    age: 30

};

console.log(ironman);
console.log(captain);

// 객체를 매개변수로 받기
function print(hero){
    let text = `${hero.alias}(${hero.name}) actor: ${hero.actor}`;
    console.log(text);
    
}

print(ironman);
print(captain);

// ES6 에 있는
// '비구조화할당 (destructuring assigment)문법'을 사용하면
// 객체변수.속성  <-- 좀더 편리하게 다룰수 있다.
// '비구조화할당 문법'
//   다른말로 '객체 구조 분해'

// 공식
// https://www.ecma-international.org/ecma-262/6.0/#sec-destructuring-assignment
// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
// 추가 참조
// https://velog.io/@public_danuel/destructuring-assignment

// 비구조화 할당, 잘 사용하면 코드 깔끔해진다

function print(hero){
    // destructuring assignment : 객체 구조 분해
    const {alias, name, actor} = hero;
    // 어떤 (key) 값을 추출할지 명시
    
    let text = `${alias}(${name}) actor: ${actor}`;
    console.log(text);
}

console.log('-------------------------------------');
print(ironman);
print(captain);

// 함수 parameter 에도 비구조화 할당 가능!
// 훨씬 깔끔
function print2({alias, name, actor, age}) {
    let text = `${alias}(${name}) actor: ${actor} and ${age}`;
    console.log(text);
}

console.log('-------------------------------------');
print2(ironman);
print2(captain);

// 꼭 함수 안에서만 사용할수 있는거 아니다
const {name} = ironman;
console.log(name + " " + typeof name);