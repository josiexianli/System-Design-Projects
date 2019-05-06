package xianli.assignment7;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ItemFinder {
	
	JavaDBConnection database;
private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	public void setDatabase(JavaDBConnection database) {
		this.database = database;
	}
	
	private static final class ItemMapper implements RowMapper<ItemDAO> {
		public ItemDAO mapRow(ResultSet rs, int rowNum)
		throws SQLException {
			ItemDAO item = new ItemDAO();
			item.setItemId(rs.getInt("itemId"));
			item.setReserved(rs.getBoolean("isReserved"));
			item.setActorId(rs.getInt("actorId"));
			item.setName(rs.getString("itemName"));
			return item;
		}
	};
	public List<ItemDAO> findItem(String itemName, int actorId) {
		List<ItemDAO> allItems = jdbcTemplate.query("SELECT * FROM Items", new ItemMapper());
		return allItems; 
	}
}
