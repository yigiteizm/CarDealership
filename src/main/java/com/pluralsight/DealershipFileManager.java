package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {
    public DealerShip getDealership() {
        String line;
        DealerShip dealership = null;
        {


            try {
                BufferedReader br = new BufferedReader(new FileReader("dealership.csv"));
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");

                    if (parts.length == 3) {
                        String dealerShipName = parts[0];
                        String dealerShipAdress = parts[1];
                        String dealerShipPhoneNumber = parts[2];

                        dealership = new DealerShip(dealerShipName, dealerShipAdress, dealerShipPhoneNumber);
                    } else {

                        // Araç bilgilerini oku ve nesne oluştur / Read vehicle information and create an object
                        int vin = Integer.parseInt(parts[0]);
                        int year = Integer.parseInt(parts[1]);
                        String make = parts[2];
                        String model = parts[3];
                        String vehicleType = parts[4];
                        String color = parts[5];
                        int odometer = Integer.parseInt(parts[6]);
                        double price = Double.parseDouble(parts[7]);

                        Vehicle vehicle = new Vehicle(vin, year, odometer, make, model, vehicleType, color, price);
                        dealership.addVehicle(vehicle);
                    }

                }
            } catch (Exception e) {
                System.out.println("Error reading file");
                e.printStackTrace();
            }

            return dealership;
        }


    }
}