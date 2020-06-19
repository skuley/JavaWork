package com.lec.spring.config02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.beans.Score;
import com.lec.beans.Student;

// Java 클래스를 이용한 설정
// 클래스 이름앞에 반드시 어노테이션 명시 필요
// @Configuration --> 이 클래스는 'spring 설정' 에 사용되는 클래스입니다.라고 알려준다
// 결국 컨테이너 역할을 한다.

@Configuration
public class AppConfig02 {
	
	@Bean
	public Score score1() { // 메소드 이름 score1 이 bean의 name값(id값) 이 된다.
		return new Score(100, 85, 75, "Very Well~");
	}
	
	@Bean
	public Student student1() {
		return new Student("훈지예지", 34, score1());
	}
	
}
