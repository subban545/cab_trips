package com.datarepublic.trips.service;

import java.util.Date;

public interface TripsDataService {
    public Long findTripsByIdAndDate(String id, Date start, Date end);

    public void evictCache();
}
