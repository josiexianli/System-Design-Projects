package xianli.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AccountFinder {
	 private static String dbURL = "jdbc:derby:assignment3;create=true";
	    
	    private static Connection conn = null;
	    private static Statement stmt = null;
    
	    private static void createConnection()
	    {
	        try
	        {
	            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	            //Get a connection
	            conn = DriverManager.getConnection(dbURL); 
	        }
	        catch (Exception except)
	        {
	            except.printStackTrace();
	        }
	    }

	
	public List<AccountDAO> findAccount(String userName) {
		List<AccountDAO> allAccounts = new ArrayList<>();
			try
	        {
				createConnection();
	            stmt = conn.createStatement();
	            ResultSet results = stmt.executeQuery("select * from Accounts where user_name = " + "'" + userName + "'");
	            while(results.next())
	            {
	            	String username = results.getString(1);
	            	String password = results.getString(2);
	            	String email = results.getString(3);
	            	AccountDAO curAccount = new AccountDAO(username, password, email);
	            	allAccounts.add(curAccount);
	            }
	            results.close();
	            stmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
			return allAccounts;
		}
}
