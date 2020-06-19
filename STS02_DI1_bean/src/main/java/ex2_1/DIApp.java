package ex2_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		OperatorBean op = null;
		
		op = ctx.getBean("plus", OperatorBean.class);
		int sum = op.doOperate();
		System.out.println("sum : " + sum);
		
		op = ctx.getBean("minus", OperatorBean.class);
		int sub = op.doOperate();
		System.out.println("subtract : " + sub);
		
		ctx.close();

	}

}
