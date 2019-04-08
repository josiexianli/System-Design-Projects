package xianli.assignment5;

import java.sql.SQLException;

public class ReservationGateway {
	
JavaDBConnection database;
    
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	public void updateReservationRecord(int reservationId) {
		try
        {
			database.stmt = database.conn.createStatement();
			database.stmt.execute("update Reservations set isFilled = true where reservation_Id = " + reservationId);
			database.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
}
