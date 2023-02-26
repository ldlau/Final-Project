package com.promineotech.location.dao;

import java.util.List;
import com.promineotech.book.entity.Location;

public interface LocationDao {
  /**
   * @param locationName
   */
  
  List<Location> fetchAvailableLocations(String locationName);
}