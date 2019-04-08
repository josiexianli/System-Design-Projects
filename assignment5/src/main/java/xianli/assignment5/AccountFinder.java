package xianli.assignment5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountFinder {
	
JavaDBConnection database;
    
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}

	
	public List<AccountDAO> findAccount(String userName) {
		List<AccountDAO> allAccounts = new ArrayList<>();
		try {
			database.stmt = database.conn.createStatement();
			ResultSet results = database.stmt.executeQuery("select * from Accounts where user_name = " + "'" + userName + "'");
            
            while (results.next()) {
            	String username = results.getString(1);
            	String password = results.getString(2);
            	String email = results.getString(3);
            	AccountDAO curAccount = new AccountDAO(username, password, email);
            	allAccounts.add(curAccount);
            }
            results.close();
            database.stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allAccounts;
	}
}
