/*
프로토타입과 클래스
객체 생성자
프로토타입과 클래스에 대해서 알아보기 전에 
우선 객체 생성자라는 것을 알아봅시다. 

객체 생성자는 '함수'를 통해서 
새로운 '객체'를 만들고 
그 안에 '넣고 싶은 값' 혹은 '함수'들을 
구현 할 수 있게 해줍니다.
*/

// Animal 이라는 객체 생성자
// (일반적으로 대문자로 시작하는 작명)


function Animal(type, name, sound){
    this.type = type,
    this.name = name,
    this.sound = sound;
    this.say = function(){
        console.log(this.sound);
        
    }
}

let dog = new Animal('dog', 'doggy', 'bark!!');
let cat = new Animal('cat', 'kitty', 'meow~');

dog.say();
cat.say();

/*
  고찰..
  새로운 객체가 new 생성될때마다
  각 객체의 type, name, sound, say 가 '새로' 만들어진다.
  음.. say 는 함수인데.. 계속 새로 만들어진다?
  (비효율적이다, 함수는 동일한 내용인데...)

   say 라는 함수를 바깥으로 꺼내어 재사용(?)해보기
  바로 prototype 사용! ★
*/

console.log('---------------------------');

function Animal2(type, name, sound){
    this.type = type,
    this.name = name,
    this.sound = sound;
}

Animal2.prototype.say = function(){
    console.log(this.sound);
} 

let bird = new Animal2('bird', 'pigeon', '짹짹이');
let tiger = new Animal2('tiger', 'tiger', 'cuuaaaang~');

bird.say();
tiger.say();

// prototype 에 정의해 놓으면 해당 객체가 공통으로 사용 가능하다
// instance 가 만들어졌고 prototype이 나중에 선언 되었는데도 가능하다.. 그 이유는 prototype chain 때문이다!!
Animal2.prototype.sharedValue = 1;
console.log(bird.sharedValue);
console.log(tiger.sharedValue);

bird.sharedValue = 10;
console.log(bird.sharedValue);
console.log(tiger.sharedValue);

console.log(bird);
console.log(tiger);



