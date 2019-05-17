package remoting;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HessianClientCreateAccount {
	// load the Spring context
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TransactionScriptInterface transactionStub = (TransactionScriptInterface) ctx.getBean("HessianTransactionServiceStub");
		System.out.println(transactionStub.createAccount("123", "123", "123"));
	}
	
}
