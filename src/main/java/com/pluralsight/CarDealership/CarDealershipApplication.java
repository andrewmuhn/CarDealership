package com.pluralsight.CarDealership;

import com.pluralsight.CarDealership.consoleapp.Menu;
import com.pluralsight.CarDealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDealershipApplication implements CommandLineRunner {

	@Autowired
	private VehicleRepository vehicleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... args) {
		int choice;
		do {
			choice = Menu.displayMenu(vehicleRepository);
		} while (choice != 99);

		System.exit(0);
	}
}
