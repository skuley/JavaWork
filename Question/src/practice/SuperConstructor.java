package practice;

class Car2{
	int wheel;
	int speed;
	String color;
	
	public Car2() {
		// TODO Auto-generated constructor stub
	}
	
	Car2(String colorCar){
		this.color = colorCar;
	}
}

class SportsCar extends Car2{
	int speedLimit;
	
	public SportsCar() {
		// TODO Auto-generated constructor stub
	}
	
	public SportsCar(String color, int speedLimit) {
		
	}
}

public class SuperConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
