package xianli.assignment3;

public class CreateAccountService {
	DAL dataLayer;
	public CreateAccountService() {
		dataLayer = new DAL();
	};
	
	public void createAccount(String username, String password, int userType) {
		//first check for duplicate account
		if (!dataLayer.hasDuplicate(username)) {
			dataLayer.createAccount(username, password, userType);
		}
	}
}
