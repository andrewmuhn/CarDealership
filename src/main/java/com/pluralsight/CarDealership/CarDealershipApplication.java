package com.pluralsight.CarDealership;

import com.pluralsight.CarDealership.consoleapp.TableHeaders;
import com.pluralsight.CarDealership.models.Vehicle;
import com.pluralsight.CarDealership.models.VehicleType;
import com.pluralsight.CarDealership.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.CarDealership.models.VehicleType.*;

@SpringBootApplication
public class CarDealershipApplication implements CommandLineRunner {

	@Autowired
	private VehicleRepository vehicleRepository;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(CarDealershipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Vehicle> allVehicleList = vehicleRepository.getAllVehicles();
		List<Vehicle> makeModelVehicleList = vehicleRepository.getVehiclesByMakeModel("toyota", "CAMRY");
		List<Vehicle> yearRangeVehicleList = vehicleRepository.getVehiclesByYear(2005, 2011);
		List<Vehicle> colorVehicleList = vehicleRepository.getVehiclesByColor("red");
		List<Vehicle> mileageRangeVehicleList = vehicleRepository.getVehiclesByMileageRange(120000, 140000);
		List<Vehicle> typeVehicleList = vehicleRepository.getVehiclesByType(PASSENGER_VAN);


		TableHeaders.printVehicleHeader();
//		allVehicleList.forEach(System.out::println);
//		makeModelVehicleList.forEach(System.out::println);
//		yearRangeVehicleList.forEach(System.out::println);
		colorVehicleList.forEach(System.out::println);
//		mileageRangeVehicleList.forEach(System.out::println);
//		typeVehicleList.forEach(System.out::println);

	}
}
