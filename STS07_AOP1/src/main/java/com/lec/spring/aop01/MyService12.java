package com.lec.spring.aop01;

import com.lec.beans.Logger;
import com.lec.beans.Service;

public class MyService12 extends Service {

	// 관심사(공통 기능) 코드가 함께 섞여 있는 경우.
	
	@Override
	public void doAction() {
		new Logger().logIn(); // 공통 기능
		
		// 핵심 기능
		// System.out.println("MyService12 의 doAction() 호출");
		
		printInfo();
		
		new Logger().logOut(); // 공통 기능

	}

}
