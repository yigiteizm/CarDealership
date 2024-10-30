package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private DealerShip dealerShip;
    Scanner input = new Scanner(System.in);


    public UserInterface() {

    }

    public void disPlay(){

        init();
        System.out.println("You are in :" + dealerShip.getName());
        System.out.println("Our adress is" + dealerShip.getAddress());
        System.out.println("Our phone number is" + dealerShip.getPhone());

        while(true) {
            int choosing = UserDisplayMenu();
            switch(choosing){
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

    public int UserDisplayMenu(){

        System.out.println("Welcome to Dealership Menu: ");
        System.out.println("Searching Menu: ");
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

    private void init(){

        DealershipFileManager fileManager = new DealershipFileManager();
        dealerShip = fileManager.getDealership();

    }

    private void displayVehicles(List<Vehicle> vehicle){
        for (Vehicle currentVehicle : vehicle) {
            System.out.println(currentVehicle);
        }


    public void processGetByPriceRequest() {

            System.out.println("Please Enter minimum price:");
            double minPrice = input.nextDouble();
            System.out.println("Please Enter maximum price: ");
            double maxPrice = input.nextDouble();
            List<Vehicle> vehicles = dealerShip.getVehiclesByPrice(minPrice, maxPrice);
            displayVehicles(vehicles);
        }

    }

    public void processGetByMakeModelRequest() {


    }
    public void processGetByYearRequest() {

    }
    public void processGetByColorRequest() {

    }
    public void processGetByMileageRequest() {

    }
    public void processGetByVehicleTypeRequest() {

    }
    public void processGetAllVehiclesRequest() {

    }
    public void processAddVehicleRequest() {

    }
    public void processRemoveVehicleRequest() {

    }




}
