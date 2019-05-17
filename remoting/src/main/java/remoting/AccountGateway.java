package remoting;

import org.springframework.jdbc.core.JdbcTemplate;
public class AccountGateway {
	JavaDBConnection database;
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	public void insertAccount(String username, String password, String email) {
		jdbcTemplate.update("INSERT INTO ACCOUNTS(user_name,password, email) VALUES(?,?,?)",username, password, email);
	}
	
	public void deleteAccount(String username) {
		jdbcTemplate.update("DELETE FROM ACCOUNTS WHERE user_name = ?", username);
	}
	
	
}
