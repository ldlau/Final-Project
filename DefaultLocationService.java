package com.promineotech.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.book.entity.Location;
import com.promineotech.location.dao.LocationDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultLocationService implements LocationService {
  @Autowired
  private LocationDao locationDao;
  
  @Transactional
  @Override
  public List<Location> fetchAvailableLocations(String locationName) {
    log.info("locationName={}", locationName);
    return locationDao.fetchAvailableLocations(locationName);
  }
}