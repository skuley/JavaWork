package practice;

public class Inheritance2 {
	public static void main(String[] args) {
		Leader leader = new Leader();
		leader.say();
		
		
		
	} // main
	
} // Inheritance2

class Student {
	void say(int a) {
		System.out.println("선생님 안녕하세요");
		
	}
}

class Leader extends Student{
	void lead() {
		
	}
	
	void say() {
		System.out.println("선생님께 인사!");
	}
}



