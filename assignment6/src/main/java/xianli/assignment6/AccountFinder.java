package xianli.assignment6;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AccountFinder {
	
	JavaDBConnection database;
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}

	
	private static final class AccountMapper implements RowMapper<AccountDAO> {
		public AccountDAO mapRow(ResultSet rs, int rowNum)
		throws SQLException {
			AccountDAO account = new AccountDAO();
			account.setAccountId(rs.getInt("accountId"));
			account.setUsername(rs.getString("user_name"));
			account.setPassword(rs.getString("password"));
			account.setEmail(rs.getString("email"));
			return account;
		}
	};
	
	public List<AccountDAO> findAccount(String userName) {
		List<AccountDAO> allAccounts = jdbcTemplate.query("SELECT * FROM Accounts", new AccountMapper());
		return allAccounts; 
		
	}
}
