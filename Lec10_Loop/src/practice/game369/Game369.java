package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		
		/*369게임
		1~100 까지의 자연수를 나열하되,
		10개 단위로 줄바꿈을 하고
		숫자에 3,6,9 중 하나라도 있으면 * 표시를 하기*/

		for(int i = 1; i <= 100; i++) {
			int x = i % 10; // 1의 자리
			int y = i / 10; // 10의 자리
			
			if((x == 3) || (x == 6) || (x == 9)) {
				System.out.printf("%3s ", "*");
			} else if( (y == 3) || (y == 6) || (y == 9)) {
				System.out.printf("%3s ", "*");
			} else {
				System.out.printf("%3d ", i);
			} // else
			
			if(i % 10 == 0) {
				System.out.println();
			}
			
		} // for

		
		int a = 0, mok , nam ; 
		
		for(int i=0 ;i<100; i++) {
			 a++;
			 mok = a/10 ; 
			 nam = a%10 ; 
			 if(mok != 0 && mok%3 == 0 && nam == 0 ) {
				System.out.print("* ");
			 }else if(mok != 0 && mok%3 == 0 && nam%3 ==0  ){
					 System.out.print("* ");
			 }else {
				 System.out.print(a + " ");
			 }
			 
//			 int a1 = 1 % 10;
//			 System.out.println(a1);
			 
		}//for
	} // main
	
}
