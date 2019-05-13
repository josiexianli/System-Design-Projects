package account.controller;

import org.springframework.jdbc.core.JdbcTemplate;

//not necessary for this assignment since we are not updating Item records, only fetching
public class ItemGateway {
JavaDBConnection database;
private JdbcTemplate jdbcTemplate;

public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
	this.jdbcTemplate = jdbcTemplate;
}
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
}
