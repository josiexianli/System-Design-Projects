package xianli.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAL {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "sunshangyu1234";
	
	public DAL() {
		
	}
	
	public Connection getConnection() {
		Connection conn = null;
 	   	try{
 	   		//STEP 2: Register JDBC driver
 	   		Class.forName("com.mysql.cj.jdbc.Driver");

 	   		//STEP 3: Open a connection
 	   		System.out.println("Connecting to database...");
 	   		conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	   	} catch (Exception e){
  	      //Handle errors for Class.forName
  	      e.printStackTrace();
 	   	}
 	   	return conn;
	}
	
	public void executeStatement(Connection conn, String inputStatement) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(inputStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasDuplicate(String username) {
		boolean result = false;
		Connection dbConn = getConnection();
		PreparedStatement pSelect = null;
		try {
			pSelect = dbConn.prepareStatement("select r_object_id from financial_data");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rsSelect = null;
		try {
			rsSelect = pSelect.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rsSelect.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void createAccount(String username, String password, int userType) {
		Connection dbConn = getConnection();
		try {
			PreparedStatement pStmt = dbConn.prepareStatement("insert into user values" +"("+username + "," + password + "," + userType +")");
			pStmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void returnItem(int itemId, int actorId, String email) {
		Connection dbConn = getConnection();
		PreparedStatement pSelect = null;
		try {
			pSelect = dbConn.prepareStatement("select r_object_id from financial_data");
			pSelect.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rsSelect = null;
		try {
			rsSelect = pSelect.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String isReserved = null;
		try {
			isReserved = (String)rsSelect.getObject("isReserved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isReserved.equals("1")) {
			try {
				PreparedStatement pStmt = dbConn.prepareStatement("update table item set isReserved = 0, reserve_user_id = " + actorId +
						"where email = " + email);
				pStmt.executeQuery();
				System.out.println("Email has been sent to " + email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
