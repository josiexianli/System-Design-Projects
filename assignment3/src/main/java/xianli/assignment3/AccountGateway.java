package xianli.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountGateway {
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
	
	public void insertAccount(String username, String password, String email) {
		try
        {
			createConnection();
			stmt = conn.createStatement();
			stmt.execute("insert into Accounts (user_name, password, email, userType) values ( " + username + "," + password + "," + email + ", 1)");
			stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	public void deleteAccount(String username) {
		try
        {
			createConnection();
			stmt = conn.createStatement();
			stmt.execute("delete from Accounts where user_name = " + "'" + username + "'");
			stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	
}
