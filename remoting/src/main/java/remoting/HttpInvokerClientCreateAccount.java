package remoting;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpInvokerClientCreateAccount {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		TransactionScriptInterface transactionStub = (TransactionScriptInterface) ctx.getBean("HttpInvokerTransactionServiceStub");
		System.out.println(transactionStub.createAccount("123", "123", "123"));
	}
}
