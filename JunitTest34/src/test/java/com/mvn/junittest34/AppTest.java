package com.mvn.junittest34;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest {

	// 실습1
    @Test
    public void test1() {
        int[] arr = {5, 4, 7, 3, 1};
        int[] arr2 = new int[arr.length];
        App app = new App();
        app.sortArr(arr);
        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];

            if(arr2[i] != arr[i]){
                fail();
            }
        }

    }

    @BeforeClass
    public static void beforeTest2(){
        final String TEST_DIRECTORY = "test";
        final String TEST_FILE = "report.txt";

        String path = System.getProperty("user.dir") + File.separator + TEST_DIRECTORY;
        System.out.println(path);

        File file = new File(path);

        if(!file.exists()) {
            if(file.mkdir()) {
                System.out.println("폴더 생성 성공");
            } else {
                System.out.println("폴더 생성 실패");
            }
        } else {
            System.out.println("폴더가 이미 존재합니다");
        }


        File txtFile = new File(file, TEST_FILE);

        if(!txtFile.exists()) {
            // 파일이 존재하지 않으면 생성
            try {
                if(txtFile.createNewFile()) { // 물리적인 파일 생성
                    System.out.println("파일 생성 성공");
                } else {
                    System.out.println("파일 생성 실패");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 파일이 존재한다면
            System.out.println("파일이 이미 존재합니다");
        }

    }

    // 실습2
    @Test
    public void test2() {
        int[] arr = {4, 66, 21};
        String report = "";

        App app = new App();

        report = "max 값 : " + Integer.toString(app.max(arr)) + " " +
                "min 값 : " + Integer.toString(app.min(arr));
        System.out.println(report);

        String path = "test/report.txt";

        try {
            FileWriter fw =  new FileWriter(path);
            fw.write(report);

            fw.flush();
            fw.close();
        } catch (IOException e) {
            fail();
        }
    }
}
