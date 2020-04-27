package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {

		// 스스로 못해
		// http://blog.naver.com/PostView.nhn?blogId=tipsware&logNo=
		// 221302594169&categoryNo=0&parentCategoryNo=82&viewDate=&
		// currentPage=1&postListTopCurrentPage=1&from=postView
		// 블로그 읽고 곱씹어 설명함.

		// 대부분 우린 중첩 for문을 돌릴때 int i 를 선언/초기화 시켜 출력에 앞에 올값을 넣어서 생각했지만
		// 여기선 그것이 성립이 되지 않는다.
		// 자 보자.
		// int i는 단 즉 2~9를 나타내는 변수이다.
		// 우리가 가로로 단을 늘려야 하기 때문에 printf로 줄바꿈 없는 출력코드를 넣었기 땜에
		// 안쪽 for문이 단이 되어야만 한다. 이것이 가로로 찍히는 것을 세로로 바꿔준다.
		// 그럼 구지 생각 안해도 밖에 있는 for문은 곱을 나타내야겠구나라고 생각할수 있다.
		for (int j = 1; j <= 9; j++) { // 곱 : 1 ~ 9
			for (int i = 2; i < 10; i++) { // 단 : 2 ~ 9
				System.out.printf("%d * %d = %2d\t", i, j, i * j);
				// 여기서 print로 출력을 안한 이유는 구구단이 올라갈수록 숫자가 커지기 때문에 정렬을 시키기 위함이다

			}
			System.out.println();
		}

		// 이제 가로로 printf를 통해 출력된 값(구구단)들을 세로로 만들어보자
		// 블로그에서 두가지 방법을 알려준다
		// 1. (단)for문을 3등분하다 : 2 ~ 4 까지 안쪽 for문 / 5 ~ 7 / 8 ~ 9
		// 2. 중첩 for문 한번 더 쓰다 : 1.번의 중복코드를 줄이기 위해 반복문을 한번더 써주기 위해서다.
		// (함수(메소드)를 쓰면 좋다. 하지만 아직 함수(메소드)를 잘 모른다)

		// 2을 가져와 써보자
		int i, j, column, loop;

		for (loop = 0; loop < 3; loop++) { // loop --> 단이 가로로 3단 이상 넘어가지 못하게 방지 해주는 제어문이다.
			// 각 열에 시작할 단을 계산한다.
			column = 2 + loop * 3; // 나도 이 생각을 안한건 아니다...ㅠㅠ
			// 9번을 반복하는 반복문을 만든다. (i = 1 ~ 9) 위와 동일하게 곱을 먼저 시작해준다. (이유는 위에 있음)
			for (j = 1; j < 10; j++) {
				// 2번 또는 3번을 반복하는 반복문을 추가한다.
				for (i = column; i < column + 3 && i < 10; i++) {
					System.out.printf("%d * %d = %d\t", i, j, i * j);

				} // for(i)
					// 한 단이 끝나면 줄바꿈 해준다
				System.out.println();
			} // for(j)
				// 3개의 단이 끝나면 추가로 줄바꿈 해준다
			System.out.println();

		} // for(loop)

		System.out.println("프로그램 종료");

//		******* 모든 for문은 while문으로 교체 가능 *******
		// 이건 내일 하자 ㅠㅠ

	} // main

} // class
