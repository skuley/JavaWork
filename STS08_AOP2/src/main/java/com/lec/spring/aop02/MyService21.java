package com.lec.spring.aop02;

import com.lec.beans.Service;

public class MyService21 extends Service {

	@Override
	public void doAction() {
		
		// 공통 기능이 없다?!?!?
		
		printInfo(); // 핵심 기능

	}
	
	public void hahaha() {
		System.out.println("hahaha");
	}

}
