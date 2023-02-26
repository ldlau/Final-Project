package com.promineotech.location.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.book.entity.Location;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultLocationDao implements LocationDao {
 
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Location> fetchAvailableLocations(String locationName) {
      log.info("DAO: locationName={}", locationName);
      
      //@formatter:off
      String sql = ""
          + "SELECT * "
          + "FROM location";
         // + "WHERE location_name = :location_name";
      //@formatter:on
      
      Map<String, Object> params = new HashMap<>();
      params.put("location_name", locationName);
      
      return jdbcTemplate.query(sql, params, new RowMapper<>() {
        @Override
        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
          //@formatter:off
          return Location.builder()
              .locationName(new String(rs.getString("location_name")))
              .build();
          //@formatter:on     
                  
        }
       });
    }
}