package practice;

public class GuGudan {

	public static void main(String[] args) {

		int loop = 0;
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%2d x %2d = %2d \t", i, j, (i * j));
				if(j % 3 == 0) System.out.println();
			}
		}

	} // main

}
