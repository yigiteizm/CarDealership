package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {
    public DealerShip getDealership() {
        String line;
        DealerShip dealership = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("dealership.csv"));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String dealerShipName = parts[0];
                    String dealerShipAddress = parts[1];
                    String dealerShipPhoneNumber = parts[2];

                    dealership = new DealerShip(dealerShipName, dealerShipAddress, dealerShipPhoneNumber);
                } else {

                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer,price);
                    dealership.addVehicle(vehicle);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(DealerShip dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"))) { // Overwrite mode

            writer.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());
            writer.newLine();


            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
