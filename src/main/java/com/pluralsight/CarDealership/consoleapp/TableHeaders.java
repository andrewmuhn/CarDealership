package com.pluralsight.CarDealership.consoleapp;

public class TableHeaders {
    public static void printVehicleHeader() {
        System.out.printf("\u001b[31;1m\u001b[4m\u001b[1m| %-18s | %-12s | %-12s | %-12s | %-12s | %-14s | %-12s | %-12s | %-12s |\u001b[0m\n",
                "vin", "sold", "year", "make", "model", "vehicleType", "color", "odometer", "price");
    }
}
