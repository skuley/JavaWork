package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	private String company;
	
	
	// getter & setter
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	// 메소드 재정의 (Overriding)
	//@Override
	/*public void showInfo() {
		super.showInfo();
		System.out.println("회사 : " + company);
	}*/
	
	public void showInfo(int id) {
		System.out.println("id : " + id);
		showInfo();
	}
	
	//
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사 : " + company);
	}
	
	// 이클립스 단축키
	// Alt + Shift + S, V

	// final 메소드는 오버라이딩 불가
	/*@Override
	public void whoAreYou() {
		super.whoAreYou();
	}*/
	
	
	// 객체를 문자열로 표현한다
	@Override
	public String toString() {
		return "BusinessPerson: " + getName() + " " + company;
	}
	
}
