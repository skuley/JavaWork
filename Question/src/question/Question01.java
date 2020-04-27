package question;

public class Question01 extends AbstractClass implements MainIntereface{

	public static void main(String[] args) {
		
		// (명시적 형변환)
		// 왜 출력값이 이렇게 나오지??
		byte num5 = (byte)128;
		System.out.println("num5 = " + num5);
		
		// 부호비트
		// 맨 앞자리수가 1이면 
		
		
		String test = "안녕하세요";
		System.out.println(test.getBytes().length);
		
		
		// 04.01
		// ImageIO 에서 데이터 크기나 몇개 받는지 알수 있는지...?
		
		
		// -----------------------------------
		System.out.println(MainIntereface.num1);
		System.out.println(MainIntereface.num2);
		
		int num = MainIntereface.num1;
		System.out.println(num);
		
		AbstractClass ac = new AbstractClass() {
			
			@Override
			public int abstractExample() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		
	} // main

	@Override
	public int abstractExample() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String abstractExample2() {
		// TODO Auto-generated method stub
		return super.abstractExample2();
	}

}
