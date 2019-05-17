package remoting;


public class AccountDAO {
	int accountId;
	
	String username;
	
	String password;
	
	String email;
	

	
	public AccountDAO(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public AccountDAO() {}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", username=" + username + ", password=" + password + ", email="
				+ email + "]";
	}
}
