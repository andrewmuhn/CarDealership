package com.pluralsight.CarDealership.models;

public class Vehicle {
    private String vin;
    private boolean sold;
    private int year;
    private String make;
    private String model;
    private VehicleType vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(String vin, boolean sold, int year, String make, String model, VehicleType vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.sold = sold;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("\u001b[36m| %-18s | %-12b | %-12d | %-12s | %-12s | %-14s | %-12s | %-12s | %-12.2f |\u001b[0m",
                vin, sold, year, make, model, vehicleType.toString().substring(0, 1).toUpperCase() + vehicleType.toString().substring(1).toLowerCase(), color, odometer, price);
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public boolean isSold() {
        return sold;
    }
    public void setSold(boolean sold) {
        this.sold = sold;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
