package com.lec.spring.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIMain05 {

	public static void main(String[] args) {
		System.out.println("DIMain05 START!");
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:studentCtx2.xml");
		System.out.println("-- 컨테이너 생성 --");
		
		
		
		ctx.close();
		System.out.println("DIMain05 END!");

	} // main()

} // DIMain05
