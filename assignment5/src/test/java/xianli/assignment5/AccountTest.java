package xianli.assignment5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

public class AccountTest {
	
	@Test
	public void testCheckDuplicates() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		TransactionScript script = (TransactionScript) context.getBean("transactionBean");
		assertTrue(script.hasDuplicates("xianli"));
	}
	
	@Test
	public void testCreateAccount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		TransactionScript script = (TransactionScript) context.getBean("transactionBean");
		boolean result = script.createAccount("newAccount", "test123", "test@gmail.com");
		script.deleteAccount("newAccount");
		assertFalse(result);
	}
	
}
