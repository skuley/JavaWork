package com.lec.spring.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;
import com.lec.spring.Student;

public class DIMain05 {

	public static void main(String[] args) {
		System.out.println("DIMain05 START!");
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:studentCtx2.xml");
		System.out.println("-- 컨테이너 생성 --");
		
		Score score = null;
		
		score = ctx.getBean("score1", Score.class);
		System.out.println(score);
		
		System.out.println(ctx.getBean("score2", Score.class));
		
		System.out.println(ctx.getBean("student1", Student.class));
		System.out.println(ctx.getBean("student2", Student.class));
		
		ctx.close();
		System.out.println("DIMain05 END!");

	} // main()

} // DIMain05
