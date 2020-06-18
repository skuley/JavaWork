package com.lec.spring.di04;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Student;

public class DIMain04 {

	public static void main(String[] args) {
		System.out.println("DIMain04 시작!");
		
		// 컨테이너 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:studentCtx.xml");
		
		System.out.println("-- 컨테이너 생성 --");
		
		Student std = null;
		
		std = ctx.getBean("Hong", Student.class);
		System.out.println(std);
		
		Student std2 = ctx.getBean("Joo", Student.class);
		System.out.println(std2);
		
		System.out.println();
		
		std2.getScore().setKor(100);
		System.out.println(std2);
		System.out.println(std);
		
		System.out.println(ctx.getBeanDefinitionCount());
		
		
		ctx.close();
		
		
		
		System.out.println("DIMain04 종료!");

	} // main()

} // DIMain04{}
