package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private DealerShip dealerShip;
    private DealershipFileManager fileManager = new DealershipFileManager();
    Scanner input = new Scanner(System.in);


    public UserInterface() {

    }

    public void disPlay() {

        init();
        System.out.println("Welcome to " + dealerShip.getName() + " " +  dealerShip.getAddress());
        System.out.println("Communication: " + dealerShip.getPhone());

        while (true) {
            int choosing = UserDisplayMenu();
            switch (choosing) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("We hope to see you again at our Dealership!");
                    return;
                default:
                    System.out.println("Oops! That option isn't available. Please try again.");
            }
        }

    }


    public int UserDisplayMenu() {

        System.out.println("Welcome to Car World. ");
        System.out.println("Car World's Menu: ");
        System.out.println("1- Search vehicles within a price range: ");
        System.out.println("2- Search vehicles by make/model: ");
        System.out.println("3- Search vehicles by year: ");
        System.out.println("4- Search vehicles by color: ");
        System.out.println("5- Search vehicles by miles range: ");
        System.out.println("6- Search vehicles by type: ");
        System.out.println("7- List All vehicles: ");
        System.out.println("8- Adding vehicle: ");
        System.out.println("9- Removing vehicle: ");
        System.out.println("99-Quit");

        System.out.println("Please enter an option: ");
        int choosing = input.nextInt();
        input.nextLine();
        return choosing;

    }

    private void init() {

        DealershipFileManager fileManager = new DealershipFileManager();
        dealerShip = fileManager.getDealership();

    }

    private void displayVehicles(List<Vehicle> vehicle) {
        for (Vehicle currentVehicle : vehicle) {
            System.out.println(currentVehicle);
        }

    }

    public void processGetByPriceRequest() {
        System.out.println("Could you please enter the minimum price?");
        double minPrice = input.nextDouble();
        System.out.println("Now, please enter the maximum price: ");
        double maxPrice = input.nextDouble();
        List<Vehicle> vehicles = dealerShip.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Please enter the make of the vehicle: ");
        String make = input.nextLine();
        System.out.println("Now, could you enter the model? ");
        String model = input.nextLine();
        List<Vehicle> vehicles = dealerShip.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.println("Please provide the minimum year:");
        int minYear = input.nextInt();
        System.out.println("Thank you! Now, please enter the maximum year: ");
        int maxYear = input.nextInt();
        List<Vehicle> vehicles = dealerShip.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.println("Could you please specify the color of the vehicle? ");
        String color = input.nextLine();
        List<Vehicle> vehicles = dealerShip.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.println("Please enter the minimum mileage:");
        int minMileages = input.nextInt();
        System.out.println("Now, please enter the maximum mileage: ");
        int maxMileages = input.nextInt();
        List<Vehicle> vehicles = dealerShip.getVehiclesByMileage(minMileages, maxMileages);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Could you kindly enter the type of vehicle (Sedan, Truck, SUV, van): ");
        String type = input.nextLine();
        List<Vehicle> vehicles = dealerShip.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealerShip.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        System.out.println("Please enter the VIN: ");
        int vin = input.nextInt();
        System.out.println("What year is the vehicle? ");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Could you please provide the make? ");
        String make = input.nextLine();
        System.out.println("Now, please enter the model: ");
        String model = input.nextLine();
        System.out.println("What type is the vehicle (Sedan, Truck, SUV, Van)? ");
        String type = input.nextLine();
        System.out.println("Could you specify the color? ");
        String color = input.nextLine();
        System.out.println("Please enter the mileage: ");
        int odometer = input.nextInt();
        System.out.println("Finally, what is the price? ");
        double price = input.nextDouble();

        Vehicle vehicle;
        vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealerShip.addVehicle(vehicle);
        fileManager.saveDealership(dealerShip);
        System.out.println("Thank you! Your vehicle has been successfully added!");
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Please enter the VIN of the vehicle you wish to remove: ");
        int vin = input.nextInt();
        input.nextLine();

        Vehicle vehicle = dealerShip.getVehicleByVin(vin);
        if (vehicle != null) {
            dealerShip.removeVehicle(vehicle);
            fileManager.saveDealership(dealerShip);
            System.out.println("The vehicle with vin " + vin + " has been successfully removed.");
        } else {
            System.out.println("I'm sorry, but no vehicle with vin " + vin + " was found.");
        }
    }
    }
