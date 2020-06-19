package com.lec.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * 참고로,
 *   일전에 JSP Model2 에서 
 *   Command 라고 배웠던 객체를 Spring 에서 "Service 단(layer)"라고 한다.
 * */

public interface Service {}

class RegisterService implements Service{
	DAO dao;
	
	// 기본 생성자는 없다
	
	public RegisterService(DAO dao) {
		System.out.printf("RegisterService(%s) 생성\n", dao.toString());
		this.dao = dao;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[RegisterService : %s]", dao.toString());
	}
	
}

// 기본생성자가 없는 Service 객체 다시 생성
class ReadService implements Service{
	DAO dao;
	
	// 기본 생성자는 없다
	
	// 생성자에 @Autowired 자동주입
	// 매개변수 "타입"과 일치하는 bean 객체가 자동 주입된다.
	@Autowired
	public ReadService(DAO dao) {
		System.out.printf("ReadService(%s) 생성\n", dao.toString());
		this.dao = dao;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[ReadService : %s]", dao.toString());
	}
	
}


class UpdateService implements Service{
	// 멤버변수에 @Autowired 자동주입
	// 멤버변수 '타입'과 일치하는 bean 객체가 자동 주입된다
	@Autowired
	DAO dao;
	
	// 기본 생성자 있다~!
	
	public UpdateService() {
		System.out.println("UpdateService() 생성");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[UpdateService : %s]", dao.toString());
	}
	
}

class DeleteService implements Service{
	DAO dao;
	
	// 기본 생성자
	public DeleteService() {
		System.out.println("DeleteService() 생성");
	}
	
	// setter 에 @Autowired 자동주입
	// setter 의 매개변수 '타입' 과 일치하는 bean 객체가 주입된다.
	// <property> 가 없어도 setter 가 호출된다
	@Autowired
	public void setDao(DAO dao) {
		System.out.printf("setDao(%s) 호출\n", dao.toString());
		this.dao = dao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[DeleteService : %s]", dao.toString());
	}
}


// 두개의 DAO 멤버변수
class ListService implements Service{
	@Autowired
	@Qualifier("memberDAO")
	DAO memberDao;
	DAO boardDao;
	
	public ListService() {
		System.out.println("ListService() 생성");
	}

	@Autowired
	@Qualifier("boardDAO")
	public void setBoardDao(DAO boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[ListService : %s, %s]", memberDao.toString(), boardDao.toString());
	}
	
	
}










