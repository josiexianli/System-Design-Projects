package xianli.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservationGateway {
	
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
	
	public void updateReservationRecord(int reservationId) {
		try
        {
			createConnection();
			stmt = conn.createStatement();
			stmt.execute("update Reservations set isFilled = true where reservation_Id = " + reservationId);
			stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
	}
}
