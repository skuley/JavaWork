package com.lec.java.inner07;

/*
  Anonymous inner class(익명 내부 클래스):
   이름이 없는 local inner class
   이름이 없기 때문에 생성자를 만들 수가 없습니다.
   클래스의 정의와 동시에 인스턴스를 생성합니다.
   
   Java는 객체지향 언어이기 때문에 모든 처리를 해주려면 
      객체를 만들어서 처리를 해줘야해서 객체 이름을 만들어야 한다.
      이러한 번거로움을 줄이기 위해 익명(Anyonymous)로 내부 클래스를 만든다.
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");
		
		Person person = new Person("ABC");
		Readable r = person.createInstance(55);
		r.readInfo();
		
		Readable r2 = new Readable() {
			
			@Override
			public void readInfo() {
				System.out.println("r2 의 readInfo 입니다");
				
			}
		};
		
		r2.readInfo();
		
		Readable r3 = new Readable() {
			
			@Override
			public void readInfo() {
				System.out.println("r3의 readInfo 입니다");
			}
		};
		
		r3.readInfo();
		
		new Readable() {

			@Override
			public void readInfo() {
				System.out.println("따끈따끈한 readInfo()");
			}
			
		}.readInfo();
		
		Movable m1 = new Movable() {
			
			@Override
			public void move(int time) {
				System.out.println("move() : " + time * speed);
			}
		};
		
		m1.move(2);
		m1.move(3);
		m1.move(5);
		
		
		MyClass m2 = new MyClass();
		m2.aaa();
		m2.bbb();
		
		MyClass m3 = new MyClass() {
			@Override
			public void aaa() {
				System.out.println("AAA");
			}
		};
		
		m3.aaa();
		
		MyClass my3 = new MyClass() {

			@Override
			public void aaa() {
				System.out.println("AAA");
			}

			@Override
			public void bbb() {
				System.out.println("BBB");
			}
			// Alt + Shift + S, V
			// Override 단축키
		};
		
		my3.aaa();
		my3.bbb();
		
		
	} // end main()

} // end class Anonymous01Main


abstract class Movable{
	int speed = 100;
	public abstract void move(int time);
}

class MyClass{
	public void aaa() {
		System.out.println("aaa");
	}
	
	public void bbb() {
		System.out.println("bbb");
	}
}










