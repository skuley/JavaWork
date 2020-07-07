package com.mvn.junittest34;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class AppTest3 {

	private String expected;
	private String value;
	
	@Parameterized.Parameters
	public static Collection<String[]> getNumberParam(){
		return Arrays.asList(new String[][]{
				{"01065285654", "010-6528-5654"},
				{"01098422131", "010-9842-2131"},
				{"01032092131", "010-3209-2131"}
		});
	}

	public AppTest3(String expected, String value) {
		this.expected = expected;
		this.value = value;
	}

	// 실습3
	@Test
	public void test() {
		String num = "010-6528-5654";
		App app = new App();
		assertEquals(expected, app.toNumber(value));

	}

}
