package wswEat;

//Model 객체
//데이터 표현 객체
public class WeModel {

	private String resName;
	private String menu;
	private String addr;
	private int price;
	private int rate;
	private int visit;
	
	
	public WeModel() {
		// TODO Auto-generated constructor stub
	}

	
	public WeModel(String resName, String menu, String addr, int price, int rate, int visit) {
		super();
		this.resName = resName;
		this.menu = menu;
		this.addr = addr;
		this.price = price;
		this.rate = rate;
		this.visit = visit;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getVisit() {
		return visit;
	}

	public void setVisit(int visit) {
		this.visit = visit;
	}
	
	
	
	
} // weModel
