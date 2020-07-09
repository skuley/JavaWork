package com.lec.sts18_security.security;

import junit.framework.TestCase;
import org.junit.*;

import static org.junit.Assert.*;

public class TestJunit2 extends TestCase {

    @Before
    public void before(){
        System.out.println("[before()]");
    }

    @After
    public void after(){
        System.out.println("[after()]");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("<<beforeClass()>>");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("<<afterClass()>>");
    }


    @Test
    public void testA(){
        System.out.println("testA()");
        System.out.println("no. of Test Case = " + this.countTestCases());
        setName("test 첫번째지롱~");
        System.out.println("Test Case Name = " + this.getName());
    }

    @Test
    public void testB(){
        System.out.println("testB()");
        System.out.println("no. of Test Case = " + this.countTestCases());
        System.out.println("Test Case Name = " + this.getName());
    }

    @Test
    public void testC(){
        System.out.println("testC()");
        System.out.println("no. of Test Case = " + this.countTestCases());
        System.out.println("Test Case Name = " + this.getName());
    }

    @Test
    public void testD(){
        System.out.println("testD()");
        System.out.println("no. of Test Case = " + this.countTestCases());
        System.out.println("Test Case Name = " + this.getName());
    }

}