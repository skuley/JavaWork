package 반복제어문2.자가진단07;

public class Main {

	public static void main(String[] args) {

//		아래와 같이 출력되는 프로그램을 작성하시오.
		
//		2 3 4 5 6
//		3 4 5 6 7
//		4 5 6 7 8
//		5 6 7 8 9
//		6 7 8 9 10
		
		for(int i = 2; i <= 6; i++) {
			for(int j = 0; j < 5; j++){
				System.out.print((i + j) + " ");
			}
			System.out.println();
		} // for
		
	} // main

} // class
