package xianli.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemFinder {
	
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
	
	public List<ItemDAO> findItem(String itemName, int actorId) {
		List<ItemDAO> allItems = new ArrayList<>();
		try {
			createConnection();
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from Items where itemName = " + "'" + itemName + "' "+ " and actorId = " + actorId );
            
            while (results.next()) {
            	boolean isReserved = results.getBoolean(1);
            	ItemDAO curItem = new ItemDAO(isReserved, actorId, itemName);
            	allItems.add(curItem);
            }
            results.close();
            stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allItems;
	}
}
