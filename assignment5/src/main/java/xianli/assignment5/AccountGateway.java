package xianli.assignment5;

import java.sql.SQLException;

public class AccountGateway {
JavaDBConnection database;
    
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	public void insertAccount(String username, String password, String email) {
		try
        {
			database.stmt = database.conn.createStatement();
			database.stmt.execute("insert into Accounts (user_name, password, email, userType) values ( " + username + "," + password + "," + email + ", 1)");
			database.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	public void deleteAccount(String username) {
		try
        {
			database.stmt = database.conn.createStatement();
			database.stmt.execute("delete from Accounts where user_name = " + "'" + username + "'");
			database.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	
}
