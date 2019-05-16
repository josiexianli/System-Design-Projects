package account.controller;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JavaDBConnection {
	private static final String JDBC_URL = "jdbc:derby://localhost:80/account;create=true";
	
	Connection conn = null;
	Statement stmt = null;
	
	public JavaDBConnection() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
			this.conn = DriverManager.getConnection(JDBC_URL);
			
			if (this.conn != null) {
				System.out.println("You are in");
			}
		}catch(SQLException e) {
			System.out.println(e);
			System.out.println("Connection failed");
		}
	}
	
	public static void main(String[] args) {
    	JavaDBConnection connection = new JavaDBConnection();
    	
    	connection.createAccountTable();
    	connection.createItemTable();
    	connection.createReservationTable();
    	connection.insertRecords();
        
//        connection.dropTable();

    }
	
	public void dropTable() {
		try
        {
			stmt = conn.createStatement();
            stmt.execute("drop table Reservations");
            stmt.close();
			 stmt = conn.createStatement();
	            stmt.execute("drop table Items");
	            stmt.close();
	            
            stmt = conn.createStatement();
            stmt.execute("drop table Accounts");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	public void createAccountTable() {
		try
        {
            stmt = conn.createStatement();
            stmt.execute("create table Accounts (accountId int not null primary key generated always as identity, user_name varchar(50) not null, password varchar(50) not null, email varchar(50), userType int)");
       
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	public void createItemTable() {
		try
        {
            stmt = conn.createStatement();
            stmt.execute("create table Items (itemId int not null primary key generated always as identity, isReserved BOOLEAN NOT NULL, actorId int REFERENCES Accounts(accountId), itemName varchar(50))");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	public void createReservationTable() {
		try
        {
            stmt = conn.createStatement();
            stmt.execute("create table Reservations (reservation_id int not null primary key generated always as identity, actorId int REFERENCES Accounts(accountId), itemId int REFERENCES Items(itemId), isFilled BOOLEAN NOT NULL)");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	public void insertRecords() {
		try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into Accounts (user_name, password, email, userType) values ('xianli', 'test123', 'test@gmail.com', 1)");
            stmt.execute("insert into Items (isReserved, actorId, itemName) values ('true', 1, 'textbook')");
            stmt.execute("insert into Reservations (actorId, itemId, isFilled) values (1, 1, 'false')");
            stmt.close();
            
            
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
	
	
}
