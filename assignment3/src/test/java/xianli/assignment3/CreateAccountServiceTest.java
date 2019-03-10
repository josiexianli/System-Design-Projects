package xianli.assignment3;

import junit.framework.TestCase;
public class CreateAccountServiceTest extends TestCase {
	CreateAccountService service = new CreateAccountService();
	
	public void testCreateAccount() {
		//will fail if error thrown, otherwise it means success
		service.createAccount("test1", "password1", 0);
	}

}
