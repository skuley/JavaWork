package com.lec.sts18_security.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 * JUnit 파라미터화 테스트(Parameterized Test)
 *
 * 동일한 테스트를 @Parameters 컬렉션의 원소 개수만큼 반복 실행
 * Parameterized 클래스는 JUnit이 제공하는 많은 테스트 러너중 하나
 */

@RunWith(value = Parameterized.class)
public class TestParameter {

    private int expected;
    private int valueOne;
    private int valueTwo;

    @Test
    public void sum(){
        Calculator cal = new
    }
}