package xianli.assignment6;

import org.springframework.jdbc.core.JdbcTemplate;

public class ReservationGateway {
	
JavaDBConnection database;
private JdbcTemplate jdbcTemplate;

public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
	this.jdbcTemplate = jdbcTemplate;
}
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	public void updateReservationRecord(int reservationId) {
		jdbcTemplate.update("UPDATE Reservations set isFilled = true where reservation_Id = ?", reservationId);
	}
}
