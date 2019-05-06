package xianli.assignment7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class ReservationFinder {
	
	JavaDBConnection database;
private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	private static final class ReservationMapper implements RowMapper<ReservationDAO> {
		public ReservationDAO mapRow(ResultSet rs, int rowNum)
		throws SQLException {
			ReservationDAO reservation = new ReservationDAO();
			reservation.setReservationId(rs.getInt("reservation_id"));
			reservation.setActorId(rs.getInt("actorId"));
			reservation.setItemId(rs.getInt("itemId"));
			reservation.setFilled(rs.getBoolean("isFilled"));
			return reservation;
		}
	};
	
	public List<ReservationDAO> findReservation(int itemId, int actorId) {
		List<ReservationDAO> allReservations = jdbcTemplate.query("SELECT * FROM Reservations WHERE itemId = ? and actorId = ?", new ReservationMapper(), itemId, actorId);
		return allReservations; 
	}
	
	
}
