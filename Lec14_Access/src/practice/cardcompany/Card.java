package practice.cardcompany;

public class Card {
	
	private int cardNumber;
	
	// 기본 생성자
	public Card() {
		cardNumber = Company.CARDNUM++;
	}
	
	// 오버라이딩을 해서 public Card(int cardNum){}
//	public Card(int cardNum) {
//		
//	}

	
	//getter and setter
	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	
	
	
} // end class
