package wswEat;

public interface WeInterface {

public static final String VERSION = "1.0";
	
	// 한식 / 중식 / 양식 중 택1
	public abstract int selectMenu();
	
	// 식당정보를 담을 model interface 배열
	public abstract Restaurantlist[] resList();
	
	// 랜던으로 식당 한곳만 가져오기
	public abstract Restaurantlist selectRnd();
	
}
