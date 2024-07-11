package com.pluralsight.CarDealership.consoleapp;

import com.pluralsight.CarDealership.consoleapp.utils.CreateMenu;
import com.pluralsight.CarDealership.consoleapp.utils.TableHeaders;
import com.pluralsight.CarDealership.models.Vehicle;
import com.pluralsight.CarDealership.models.VehicleType;
import com.pluralsight.CarDealership.repositories.VehicleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static int displayMenu(VehicleRepository vehicleRepository) {
        int choice = getChoice();
        switch (choice) {
            case 1:
                System.out.println("Enter min year:");
                int minYear = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter max year:");
                int maxYear = scanner.nextInt();
                scanner.nextLine();
                List<Vehicle> yearRangeVehicleList = vehicleRepository.getVehiclesByYear(minYear, maxYear);
                TableHeaders.printVehicleHeader();
                yearRangeVehicleList.forEach(System.out::println);
                break;
            case 2:
                System.out.println("Enter min mileage:");
                int minOdo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter max mileage:");
                int maxOdo = scanner.nextInt();
                scanner.nextLine();
                List<Vehicle> mileageRangeVehicleList = vehicleRepository.getVehiclesByMileageRange(minOdo, maxOdo);
                TableHeaders.printVehicleHeader();
                mileageRangeVehicleList.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Enter color:");
                String color = scanner.nextLine().trim();
                List<Vehicle> colorVehicleList = vehicleRepository.getVehiclesByColor(color);
                TableHeaders.printVehicleHeader();
                colorVehicleList.forEach(System.out::println);
                break;
            case 4:
                break;
            case 5:
                System.out.println("Enter Vehicle Type:");
                String vehicleTypeString = scanner.nextLine().trim();
//                TODO: Convert to sub menu to select a vehicle type.
                VehicleType vehicleType = VehicleType.valueOf(vehicleTypeString);
                List<Vehicle> typeVehicleList = vehicleRepository.getVehiclesByType(vehicleType);
                TableHeaders.printVehicleHeader();
                typeVehicleList.forEach(System.out::println);
                break;
            case 6:
                System.out.println("Enter make:");
                String make = scanner.nextLine().trim();
                System.out.println("Enter model:");
                String model = scanner.nextLine().trim();
                List<Vehicle> makeModelVehicleList = vehicleRepository.getVehiclesByMakeModel(make, model);
                TableHeaders.printVehicleHeader();
                makeModelVehicleList.forEach(System.out::println);
                break;
            case 99:
                System.out.println("Exiting the application...");
                break;
            default:
                System.out.println("Invalid choice. Please try again");
                break;
        }

        return choice;
    }

    private static int getChoice() {
        HashMap<String, String> vehicleOptions = new HashMap<>();
        vehicleOptions.put("By Price", "Yellow");
        vehicleOptions.put("By Make and Model", "Yellow");
        vehicleOptions.put("By Year Range", "Yellow");
        vehicleOptions.put("By Color", "Yellow");
        vehicleOptions.put("By Mileage Range", "Yellow");
        vehicleOptions.put("By Vehicle Type", "Yellow");

        CreateMenu menu = new CreateMenu(vehicleOptions, "What vehicles would you like to get?");
        return menu.createMenu();
    }
}
