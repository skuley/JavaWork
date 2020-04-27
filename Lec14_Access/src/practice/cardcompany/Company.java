package practice.cardcompany;

public class Company {
	private int num = 1;

	static int CARDNUM = 10000;
	// 필요한 변수, 메소드, 생성자 정의하기
	
	private Company() {
		CARDNUM++;
		System.out.println(CARDNUM + "번째 인스턴스 생성");
	}
	
	private static Company instance = null;
	
	public static Company getInstance() {
		if(instance == null) {
//			singleton 패턴 만들어주는 코드.. 없으면 새로 new로 heap에 만들어준다.
			instance = new Company(); // 인스턴스를 만들어준다
		} // if
		return instance;
	}
	
	public Card createCard() {
		Card c1 = new Card();
//		Card c2 = new Card(CARDNUM);
		return c1;
	}
	
	
	
	
} // end class
