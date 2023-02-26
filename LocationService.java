package com.promineotech.location.service;

import java.util.List;
import com.promineotech.book.entity.Location;

public interface LocationService {
  
  /**
   * 
   * @param locationName
   * @return
   */
  List<Location> fetchAvailableLocations(String locationName);
  
}
