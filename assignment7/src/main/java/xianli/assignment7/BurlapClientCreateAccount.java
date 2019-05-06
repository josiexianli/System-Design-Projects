package xianli.assignment7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BurlapClientCreateAccount {
	// load the Spring context
		public static void main(String[] args) {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			TransactionScriptInterface transactionStub = (TransactionScriptInterface) ctx.getBean("BurlapTransactionServiceStub");
			System.out.println(transactionStub.createAccount("123", "123", "123"));
		}
}
