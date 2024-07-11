package com.pluralsight.CarDealership.repositories;

import com.pluralsight.CarDealership.models.Vehicle;
import com.pluralsight.CarDealership.models.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository {
    @Autowired
    private DataSource dataSource;

    public List<Vehicle> getAllVehicles(){
        String query = "SELECT * FROM vehicles";
        List<Vehicle> vehicles = new ArrayList<>();

        //try-with
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                vehicles.add(mapRowToVehicle(rs));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        String query = "SELECT * FROM vehicles WHERE LOWER(make) = ? AND LOWER(model) = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, make);
            ps.setString(2, model);

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    vehicles.add(mapRowToVehicle(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        String query = "SELECT * FROM vehicles WHERE year >= ? AND year <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    vehicles.add(mapRowToVehicle(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        String query = "SELECT * FROM vehicles WHERE LOWER(color) = LOWER(?)";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, color);

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    vehicles.add(mapRowToVehicle(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileageRange(int min, int max) {
        String query = "SELECT * FROM vehicles WHERE odometer >= ? AND odometer <= ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    vehicles.add(mapRowToVehicle(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(VehicleType vehicleType){
        String query = "SELECT * FROM vehicles WHERE vehicle_type = ?";
        List<Vehicle> vehicles = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, vehicleType.toString().toUpperCase());

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    vehicles.add(mapRowToVehicle(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle mapRowToVehicle(ResultSet rs) throws SQLException {
        String vin = rs.getString("vin");
        boolean sold = rs.getBoolean("sold");
        String make = rs.getString("make");
        int year = rs.getInt("year");
        String model = rs.getString("model");
        VehicleType vehicleType = VehicleType.valueOf(rs.getString("vehicle_type").toUpperCase());
        String color = rs.getString("color");
        int odometer = rs.getInt("odometer");
        double price = rs.getDouble("price");
        return new Vehicle(vin, sold, year, make, model, vehicleType, color, odometer, price);
    }
}
