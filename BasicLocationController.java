package com.promineotech.location.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.book.entity.Location;
import com.promineotech.location.service.LocationService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicLocationController implements LocationController {
      @Autowired
      private LocationService locationService;
      
      @Override
      public List<Location> fetchAvailableLocations(String locationName) {
        log.info("locationName={}", locationName);
        return locationService.fetchAvailableLocations(locationName);
        
      }
}