package com.datarepublic.trips.service;

import com.datarepublic.trips.model.TripsData;
import com.datarepublic.trips.repository.TripsDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TripsDataServiceImplTest {

    @Autowired
    private TripsDataRepository tripsDataRepository;

    @Test
    public void shoudld_return_trip_count_for_given_day() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date start = formatter.parse("2013-12-01");
        Date end = new Date(start.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.DATE, 1);
        end = calendar.getTime();

        TripsData trips = new TripsData();
        trips.setMedallion("123");
        trips.setPickupDatetime(start);
        tripsDataRepository.save(trips);

        Long totalTrips = tripsDataRepository.findTripsByIdAndDate("123", start, end);
        assertEquals(new Long(1), totalTrips);
    }

    @Test
    public void should_return_zero_if_no_trip_for_given_day() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date start = formatter.parse("2013-12-01");
        Date end = new Date(start.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.DATE, 1);
        end = calendar.getTime();

        Date beforeDate = new Date(start.getTime());
        calendar.setTime(beforeDate);
        calendar.add(Calendar.DATE, -5);
        beforeDate = calendar.getTime();

        TripsData tripsData = new TripsData();
        tripsData.setMedallion("123");
        tripsData.setPickupDatetime(beforeDate);
        tripsDataRepository.save(tripsData);

        Long totalTrips = tripsDataRepository.findTripsByIdAndDate("123", start, end);
        assertEquals(new Long(0), totalTrips);
    }

    @Test
    public void should_return_no_trip_for_cabId_for_given_day() throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date start = formatter.parse("2013-12-01");
        Date end = new Date(start.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.DATE, 1);
        end = calendar.getTime();

        TripsData tripsData = new TripsData();
        tripsData.setMedallion("123");
        tripsData.setPickupDatetime(start);
        tripsDataRepository.save(tripsData);

        Long totalTrips = tripsDataRepository.findTripsByIdAndDate("55", start, end);
        assertEquals(new Long(0), totalTrips);
    }
}
