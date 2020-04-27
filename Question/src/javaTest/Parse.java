package javaTest;

public class Parse {
	
	public static void parse(String str) {
		
		float f;
		
		try {
			 f = Float.parseFloat(str);
		} catch (NumberFormatException e) {
			f = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//try 블럭 안에서 선언된 변수는 try 블럭안에서만 사용되는 지역변수가 된다.

    //catch 블럭등 다른 블럭에서도 사용 가능하게 하려면 try 바깥에서 선언해야 한다
	
}
