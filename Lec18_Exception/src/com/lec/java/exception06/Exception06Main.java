package com.lec.java.exception06;

/* throws
	 메소드 설계를 할 때 예외 처리를 직접 하지 않는 경우:
	 메소드 이름 뒤에 throws Exception을 추가하면,
	 예외가 발생한 경우에는 메소드를 호출한 곳으로 exception이 던져짐.
	 'Exception' 및 이를 '직접 상속받은' Exception 을 throws 하는 메소드의 경우,
	 이 메소를 호출하는 쪽에서 반.드.시 예외 처리 (handling) 해야 한다. 안하면 에러!
	 
	 
	반면 'RuntimeException' 및 이를 상속받은 예외를 throws 하는 메소드는
	굳이 호출하는 쪽에서 매번 예외 처리 할 필요는 없다

 */
public class Exception06Main {

	// JVM이 메인을 호출한다
	// main에서 exception을 throw 하면 에러를 exception 해주려면 어디로 가야하나
	public static void main(String[] args) throws Exception {
		System.out.println("throws");
		
		System.out.println();
		TestClass test = new TestClass();
		int result = test.divide(123, 0);
		System.out.println("result = " + result);
		
		System.out.println();
		// 예외 처리를 메소드 내부에서 처리하지 않고 호출하는 (메인) 메소드로 넘기는걸 throws라고 한다
		try {
		test.divide2(123, 0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		// throws로 받은 exception은 반드시 받은 메소드에서 해결을 해야한다.
		// Unhandled exception type Exception --> 핸들링이 안됐다고 에러난다.
		
		test.divide2(111, 0);
		
//		test.divide3(222, 0);
		
		// 반드시 try~catch 처리
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 2000ms 지연
		
		System.out.println("프로그램 종료...");

	} // end main()

} // end class Exception06Main












