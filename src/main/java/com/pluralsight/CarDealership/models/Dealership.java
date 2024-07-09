package com.pluralsight.CarDealership.models;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice (int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByMakeModel (String make, String model) {
        return null;
    }
    public List<Vehicle> getVehiclesByYear (int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByColor (String color) {
        return null;
    }
    public List<Vehicle> getVehiclesByMileage (int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByType (VehicleType vehicleType) {
        return null;
    }
    public List<Vehicle> getAllVehicle () {
        return inventory;
    }
    public void addVehicle (Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle (Vehicle vehicle) {

    }
}
