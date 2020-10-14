package com.datarepublic.trips.service;

import com.datarepublic.trips.repository.TripsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;

import java.util.Date;

@Service
@CacheConfig(cacheNames={"cabTrips"})
public class TripsDataServiceImpl implements TripsDataService{

    @Autowired TripsDataRepository TripsDataRepository;

    @Cacheable
    public Long findTripsByIdAndDate(String id, Date start, Date end) {
        return TripsDataRepository.findTripsByIdAndDate(id, start, end);
    }

    @CacheEvict(value="cabTrips", allEntries=true)
    public void evictCache() {}
}
