package com.lec.sts16_interceptor.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// session 객체 가져오기
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		// Controller handler 실행전!!
		System.out.println("[preHandle] " + id);
		
		if(id == null) {
			// 만약 로그인이 되어 있지 않다면, 로그인 페이지로, redirect
			
			// 직전 request 된 url을 세션에 기록
			String urlPrior = request.getRequestURL().toString() + "?" +request.getQueryString();
			
			request.getSession().setAttribute("url_Prior_login", urlPrior);
			
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false; // 리턴 타입이 false이면 더이상 Controller 진행 안한다
		}
		
		return true; // ★ true 리턴하면 Controller Handler 진행
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Controller 실행 후(Handler 실행 직후) View 직전
		System.out.println("[postHandle]");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 뷰 response 후
		System.out.println("[afterCompletion]");
		super.afterCompletion(request, response, handler, ex);
	}

	
	
}
