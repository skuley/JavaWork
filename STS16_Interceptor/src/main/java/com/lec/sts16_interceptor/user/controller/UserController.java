package com.lec.sts16_interceptor.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public String loginOk(String id, String pw, HttpSession session) {
		String returnURL = "";
		
		if(session.getAttribute("id") != null) {
			// 기존에 id 세션값이 존재한다면 (즉, 로그인 세션정보가 있는 상태라면)
			// 일단 이전 로그인 세션 정보 삭제
			session.removeAttribute("id");
		}
		
		// ※ 실제 회원 DB 테이블을 쿼리해야 하는 부분
		if(ADMIN_ID.equals(id) && ADMIN_PW.equals(pw)) {
			// 로그인 성공
			session.setAttribute("id", id);
			String loginPrior = session.getAttribute("url_Prior_login").toString();
			
			if(loginPrior != null) {
				returnURL = "redirect:" +  loginPrior;
				session.removeAttribute("url_Prior_login");
			} else {
				// 없었다면, 디폴트로 list.do 로 이동
				returnURL = "redirect:/board/list.do";
			}
			
		} else {
			// 로그인 실패
			returnURL = "user/logfail";
		}
		
		return returnURL;
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("id");
		return "user/logout";
	}
	
} // UserController
