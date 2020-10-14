package com.datarepublic.trips;

import static org.assertj.core.api.Assertions.assertThat;

import com.datarepublic.trips.controller.TripsDataController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripsApplicationTests {

	@Autowired
	private TripsDataController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
