package com.lec.sts18_security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Login Success");

        // Authentication 객체를 이용해서 사용자가 가진 모든 권한을 문자열로 체크 가능.
        List<String> rolNames = new ArrayList<String>();
        authentication.getAuthorities().forEach(authority ->{
            rolNames.add(authority.getAuthority());
        });

        System.out.println("ROLE NAMES : " + rolNames);
        
        // 로그인한 사용자가 ROLE_ADMIN 권한을 가졌다면 로그인후 곧바로 /sample/admin 으로 이동
        if (rolNames.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/sample/admin");
            return;
        }

        // 아니면 /sample/member 이동
        if (rolNames.contains("ROLE_MEMBER")) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/sample/member");
            return;
        }
        // 만약 둘다(rolNames 가 member도 admin도 아닐경우)
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
    }
}
