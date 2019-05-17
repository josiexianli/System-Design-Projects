package remoting;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BurlapClientCreateAccount {
	// load the Spring context
		public static void main(String[] args) {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			TransactionScriptInterface transactionStub = (TransactionScriptInterface) ctx.getBean("BurlapTransactionServiceStub");
			System.out.println(transactionStub.createAccount("xianli", "test123", "123@test.com"));
		}
}
