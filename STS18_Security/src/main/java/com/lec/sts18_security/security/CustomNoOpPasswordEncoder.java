package com.lec.sts18_security.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder {

    // 주어진 rawPassword를 인코딩하여 리턴, 일반적으로 SHA-1 혹은 그 이상의 암호화 알고리즘 사용
    @Override
    public String encode(CharSequence charSequence) {
        System.out.println("encode 전 : " + charSequence);
        return charSequence.toString();
    }

    // 주어진 rawPassword 가 인코딩 된 비번과 동일한지 판정.
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        System.out.println("matches 수행: " + charSequence + "::" + s);
        return charSequence.toString().equals(s);
    }
}
