package com.mainteneceapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mainteneceapp.model.Maintenence;
import com.mainteneceapp.model.Priority;
import com.mainteneceapp.model.Status;
import com.mainteneceapp.service.IMaintenenceService;

@SpringBootApplication
public class TripappProjectRestapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TripappProjectRestapiApplication.class, args);
	}

	@Autowired
	IMaintenenceService maintenenceServiceImpl;
	
	@Override
	public void run(String... args) throws Exception {
		LocalDate startDate = LocalDate.of(2021, 10, 4);
		LocalDate endDate = LocalDate.of(2021, 11, 20);
		Maintenence maintenence = new Maintenence("BikeService","mani",startDate,endDate,Priority.HIGH,Status.valueOf("INPROGRESS"));
		maintenenceServiceImpl.addMaintenence(maintenence);
	}

}
