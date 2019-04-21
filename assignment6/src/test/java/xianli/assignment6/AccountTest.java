package xianli.assignment6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@TransactionConfiguration
public class AccountTest {
	
	@SuppressWarnings("resource")
	@Test
	@Transactional
	public void testCheckDuplicates() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		TransactionScript script = (TransactionScript) context.getBean("transactionBean");
		assertTrue(script.hasDuplicates("xianli"));
	}
	
	@SuppressWarnings("resource")
	@Test
	@Transactional
	public void testCreateAccount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		TransactionScript script = (TransactionScript) context.getBean("transactionBean");
		boolean result = script.createAccount("newAccount", "test123", "test@gmail.com");
		script.deleteAccount("newAccount");
		assertFalse(result);
	}
	
}
