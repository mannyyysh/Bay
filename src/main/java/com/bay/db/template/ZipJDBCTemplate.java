package com.bay.db.template;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bay.dao.ZipDAO;
import com.bay.domain.Zip;
import com.bay.mapper.ZipMapper;

@Service
public class ZipJDBCTemplate implements ZipDAO {
	private DataSource dataSource;
	   JdbcTemplate jdbcTemplateObject;

	public List<Zip> findZips(String zipcode, Double radius) {
		String SQL = "call zip_proximity('" + zipcode + "', " + radius + ", 'mi');";
		//String SQL = "select * from zipcodes limit 10";
		List <Zip> zips = jdbcTemplateObject.query(SQL, 
                new ZipMapper());
        return zips;
	}
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

}
