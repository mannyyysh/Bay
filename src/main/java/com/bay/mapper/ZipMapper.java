package com.bay.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bay.domain.Zip;

public class ZipMapper implements RowMapper<Zip> {
   public Zip mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Zip zip = new Zip();
      zip.setZip(rs.getString("zip"));
      zip.setLat(rs.getDouble("lat"));
      zip.setLon(rs.getDouble("lon"));
      zip.setCity(rs.getString("city"));
      zip.setState(rs.getString("state"));
      zip.setAreaCode(rs.getString("state_abbrev"));
      return zip;
   }
}