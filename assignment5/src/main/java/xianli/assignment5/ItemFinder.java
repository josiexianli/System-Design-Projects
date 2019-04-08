package xianli.assignment5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemFinder {
	
	JavaDBConnection database;
    
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	public List<ItemDAO> findItem(String itemName, int actorId) {
		List<ItemDAO> allItems = new ArrayList<>();
		try {
			database.stmt = database.conn.createStatement();
			ResultSet results = database.stmt.executeQuery("select * from Items where itemName = " + "'" + itemName + "' "+ " and actorId = " + actorId );
            
            while (results.next()) {
            	boolean isReserved = results.getBoolean(1);
            	ItemDAO curItem = new ItemDAO(isReserved, actorId, itemName);
            	allItems.add(curItem);
            }
            results.close();
            database.stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allItems;
	}
}
