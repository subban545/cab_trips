package com.datarepublic.trips.controller;

import com.datarepublic.trips.service.TripsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TripsDataController {

    @Autowired
    private TripsDataService TripsDataService;

    @GetMapping(value = "/cab/{date}")
    public Map<String, Long> tripsPerDay(@RequestParam("id") String id, @PathVariable String date) throws ParseException {
        return findTripsByIdAndDate(id, date);
    }

    @GetMapping(value = "/cab/fresh/{date}")
    public Map<String, Long> tripsPerDayFresh(@RequestParam("id") String id, @PathVariable String date) throws ParseException {
        TripsDataService.evictCache();
        return findTripsByIdAndDate(id, date);
    }

    @GetMapping(value = "/clear-cache")
    public void clearCacheCabTrips() {
        TripsDataService.evictCache();
    }

    private Map<String, Long> findTripsByIdAndDate(String id, String date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date start = formatter.parse(date);

        Date end = new Date(start.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(end);
        c.add(Calendar.DATE, 1);
        end = c.getTime();

        String[] ids = id.split(",");

        Map<String, Long> map = new HashMap<>();
        for (String medallion : ids) {
            Long total = TripsDataService.findTripsByIdAndDate(medallion, start, end);
            map.put(medallion, total);
        }

        return map;
    }

}
