package com.lec.beans;

// DTO : Data Transfer Object
//	데이터를 담아 나르기 위한 객체

// 게시글 DTO, 회원DTO, ... 필요한 데이터 객체들 만큼 정의
// 근본적으로 DTO 는 Bean 객체이다


public class WriteDTO {

	private int uid; // wr_uid 를 담기 위한것이다
	private String subject; // wr_subject
	private String content; // wr_content
 	private String name; // wr_name
 	private int viewCnt; // wr_viewcnt
 	private String regdate; // wr_regdate
	
 	// 개발시 ...
 	// 다음 3가지 네이밍은 일치시켜주는 것이 좋다.
 	// ★클래스 필드명 == DB 필드명 == form의 name명★
 	
 	public WriteDTO() {
 		super();
 		System.out.println("WriteDTO() 객체 생성");
	}
 	
	public WriteDTO(int uid, String subject, String content, String name, int viewCnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
		System.out.println("WriteDTO(uid, subject, content, name, viewCnt");
	}

	public int getUid() {System.out.println("getUid() 호출");return uid;}

	public void setUid(int uid) {
		System.out.println("setUid(" + uid + ") 호출");
		this.uid = uid;}

	public String getSubject() {
		System.out.println("getSubject() 호출");
		return subject;	}

	public void setSubject(String subject) {
		System.out.println("setSubject(" + subject + ") 호출");
		this.subject = subject;	}

	public String getContent() {
		System.out.println("setContent() 호출");
		return content;}

	public void setContent(String content) {
		System.out.println("getContent(" + content + ") 호출");
		this.content = content;	}

	public String getName() {
		System.out.println("getName() 호출");
		return name;	}

	public void setName(String name) {
		System.out.println("setName(" + name + ") 호출");
		this.name = name;	}

	public int getViewCnt() {
		System.out.println("getViewCnt() 호출\"");
		return viewCnt;	}

	public void setViewCnt(int viewCnt) {
		System.out.println("setViewCnt(" + viewCnt + ") 호출");
		this.viewCnt = viewCnt;	}

	public String getRegdate() {
		System.out.println("getRegdate() 호출");
		return regdate;	}

	public void setRegdate(String regdate) {
		System.out.println("setRegdate(" + regdate + ") 호출");
		this.regdate = regdate;	}
	
	// 테스트, 개발용으로 toString() 오버라이딩 하면 좋다.
	@Override
	public String toString() {
		return "WriteDTO]" + uid + " : " + subject + " : " + content + " : " + name + " : " + viewCnt + " : " + regdate;
	}
	
} // WriteDTO
