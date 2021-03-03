package com.techelevator.apocalypse_now.models;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCStatusDAO implements StatusDAO {
	
	JdbcTemplate template;
	
	
	public JDBCStatusDAO(DataSource datasource) {	
		this.template = new JdbcTemplate(datasource);
	}

	@Override
	public Status getCurrent() {
		String query = "SELECT * FROM status ORDER BY id DESC LIMIT 1";
		template.queryForRowSet(query);
		SqlRowSet results = template.queryForRowSet(query);
		if(results.next()) {
			Status status = new Status();
			status.setMessage(results.getString("message"));
			status.setApocalyse(results.getBoolean("is_apocalyse"));
			return status;
		}
		return null;
	}

	@Override
	public List<Status> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
