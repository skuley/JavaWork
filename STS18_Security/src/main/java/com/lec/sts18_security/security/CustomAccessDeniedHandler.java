package com.lec.sts18_security.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    // request, response 를 매개변수로 받기 때문에, 서블릿 API 직접 이용하여 handle 가능
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        System.out.println("Access Denied Handler");
        System.out.println("redirect 합니다...");

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/accessError");
    }
}
