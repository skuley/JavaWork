package com.lec.spring.autowired1;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.DAO;

public class AutowireMain01 {

	public static void main(String[] args) {
		System.out.println("Autowired 자동주입");

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:autowiredCtx1.xml");
		
		System.out.println("-- 컨테이너 생성 --");
		
		System.out.println(ctx.getBean("regService"));
		System.out.println();
		System.out.println(ctx.getBean("readService"));
		System.out.println();
		System.out.println(ctx.getBean("updateService"));
		System.out.println();
		System.out.println(ctx.getBean("deleteService"));
		
		ctx.close();
		System.out.println("Autowired 종료");
	} // main()

} // AutowireMain01 {}
