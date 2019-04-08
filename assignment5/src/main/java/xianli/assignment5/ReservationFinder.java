package xianli.assignment5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReservationFinder {
	
	JavaDBConnection database;
    
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	
	public List<ReservationDAO> findReservation(int itemId, int actorId) {
		List<ReservationDAO> allItems = new ArrayList<>();
		try {
			database.stmt = database.conn.createStatement();
			ResultSet results = database.stmt.executeQuery("select * from Reservations where itemId = " + itemId + "and actorId = " + actorId);
            
            while (results.next()) {
            	boolean isFilled = results.getBoolean(3);
            	ReservationDAO curReservation = new ReservationDAO( actorId, itemId, isFilled);
            	allItems.add(curReservation);
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
