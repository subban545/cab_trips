package com.datarepublic.trips.repository;

import com.datarepublic.trips.model.TripsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface TripsDataRepository extends JpaRepository<TripsData, Integer> {
    @Query(value = "SELECT count(c.medallion) FROM TripsData c WHERE c.medallion = :id AND (c.pickupDatetime between :start AND :end)")
    Long findTripsByIdAndDate(@Param("id") String id, @Param("start") Date start, @Param("end") Date end);
}
