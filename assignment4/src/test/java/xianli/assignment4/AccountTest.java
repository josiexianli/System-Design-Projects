package xianli.assignment4;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	
	@Test
	public void testCheckDuplicates() {
		TransactionScript script = new TransactionScript();
		assertTrue(script.hasDuplicates("xianli"));
	}
	@Test
	public void testCreateAccount() {
		TransactionScript script = new TransactionScript();
		boolean result = script.createAccount("newAccount", "test123", "test@gmail.com");
		script.deleteAccount("newAccount");
		assertFalse(result);
	}
}
