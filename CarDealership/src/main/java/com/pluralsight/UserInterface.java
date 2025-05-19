package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Dealership Menu ---");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Sell/Lease a Vehicle");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    processAllVehiclesRequest();
                    break;
                case "2":
                    processSaleOrLease();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    private void displayVehicles(java.util.List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processSaleOrLease() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter VIN of vehicle to sell/lease: ");
        int vin = Integer.parseInt(scanner.nextLine());

        Vehicle vehicle = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Customer name: ");
        String name = scanner.nextLine();

        System.out.print("Customer email: ");
        String email = scanner.nextLine();

        System.out.print("Type (SALE or LEASE): ");
        String type = scanner.nextLine().toUpperCase();

        String date = java.time.LocalDate.now().toString();
        Contract contract = null;

        if (type.equals("SALE")) {
            System.out.print("Finance? (yes/no): ");
            boolean finance = scanner.nextLine().equalsIgnoreCase("yes");
            contract = new SalesContract(date, name, email, vehicle, finance);
        } else if (type.equals("LEASE")) {
            if (java.time.Year.now().getValue() - vehicle.getYear() > 3) {
                System.out.println("Cannot lease vehicle older than 3 years.");
                return;
            }
            contract = new LeaseContract(date, name, email, vehicle);
        } else {
            System.out.println("Invalid contract type.");
            return;
        }

        new ContractFileManager().saveContract(contract);
        dealership.removeVehicle(vehicle);
        System.out.println("Contract saved and vehicle removed from inventory.");
    }
}