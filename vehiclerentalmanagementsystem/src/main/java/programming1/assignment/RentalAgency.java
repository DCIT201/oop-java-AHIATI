package programming1.assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RentalAgency {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Customer> customers;
    private Scanner scanner;

    public RentalAgency() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeVehicles();
    }

    private void initializeVehicles() {
        String[] carModels = {"Toyota Camry", "Honda Accord", "BMW 3 Series", "Mercedes C-Class", "Audi A4",
                "Lexus ES", "Tesla Model 3", "Volkswagen Passat", "Hyundai Sonata", "Kia K5",
                "Mazda 6", "Subaru Legacy", "Nissan Altima", "Ford Fusion", "Chevrolet Malibu"};

        for (int i = 0; i < carModels.length; i++) {
            String category = (i < 5) ? "Luxury" : (i < 10) ? "Economy" : "SUV";
            Car car = new Car("CAR" + String.format("%03d", i + 1),
                    carModels[i],
                    0.0,
                    true,
                    category,
                    4);
            vehicles.add(car);
        }

        String[] bikeModels = {"Harley Davidson Street", "Honda CBR", "Kawasaki Ninja", "Yamaha R1", "Ducati Monster",
                "BMW S1000RR", "Triumph Street Triple", "KTM Duke", "Suzuki GSX-R", "Indian Scout",
                "Moto Guzzi V7", "Royal Enfield", "Aprilia RS", "Norton Commando", "Victory Cross"};

        for (int i = 0; i < bikeModels.length; i++) {
            String category = (i < 5) ? "Luxury" : (i < 10) ? "Economy" : "SUV";
            MotorCycle bike = new MotorCycle("MOT" + String.format("%03d", i + 1),
                    bikeModels[i],
                    0.0,
                    true,
                    category);
            vehicles.add(bike);
        }

        String[] truckModels = {"Ford F-150", "Chevrolet Silverado", "RAM 1500", "Toyota Tundra", "GMC Sierra",
                "Nissan Titan", "Honda Ridgeline", "Jeep Gladiator", "Ford Ranger", "Toyota Tacoma",
                "Chevrolet Colorado", "Nissan Frontier", "GMC Canyon", "Dodge Dakota", "Mazda BT-50"};

        for (int i = 0; i < truckModels.length; i++) {
            String category = (i < 5) ? "Luxury" : (i < 10) ? "Economy" : "SUV";
            Truck truck = new Truck("TRK" + String.format("%03d", i + 1),
                    truckModels[i],
                    0.0,
                    true,
                    category,
                    2.5 + (i * 0.5));
            vehicles.add(truck);
        }
    }

    public void start() {
        displayWelcomeMessage();
        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = getValidChoice(1, 6);

            switch (choice) {
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    registerNewCustomer();
                    break;
                case 3:
                    rentVehicle();
                    break;
                case 4:
                    displayAllVehicles();
                    break;
                case 5:
                    displayAllCustomers();
                    break;
                case 6:
                    running = false;
                    System.out.println("\nThank you for using Alpha Vehicle Rentals! Goodbye!");
                    break;
            }
        }
    }

    private void displayWelcomeMessage() {
        System.out.println("*************************************************");
        System.out.println("*                                               *");
        System.out.println("*        Welcome to Alpha Vehicle Rentals       *");
        System.out.println("*          Your Premium Rental Service          *");
        System.out.println("*              Contact: 0531154310              *");
        System.out.println("*                                               *");
        System.out.println("*************************************************");
    }

    private void displayMainMenu() {
        System.out.println("\nNB: OPTION 4 DISPLAY ALL AVAILABLE VEHICLES");
        System.out.println("\nMain Menu:");
        System.out.println("1. Add New Vehicle");
        System.out.println("2. Register New Customer");
        System.out.println("3. Rent a Car");
        System.out.println("4. Display All Available Vehicles");
        System.out.println("5. Display All Customers");
        System.out.println("6. Exit");
        System.out.print("\nPlease enter your choice (1-6): ");
    }

    private int getValidChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.print("Please enter a valid choice (" + min + "-" + max + "): ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
        return choice;
    }

    private void addNewVehicle() {
        System.out.println("\n=== Add New Vehicle ===");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Truck");
        System.out.print("Select vehicle type (1-3): ");

        int choice = getValidChoice(1, 3);
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Category (Luxury/Economy/SUV): ");
        String category = scanner.nextLine();

        try {
            Vehicle vehicle = null;
            switch (choice) {
                case 1:
                    System.out.print("Enter passenger capacity (1-5): ");
                    int capacity = Integer.parseInt(scanner.nextLine());
                    vehicle = new Car(vehicleId, model, 0.0, true, category, capacity);
                    break;
                case 2:
                    vehicle = new MotorCycle(vehicleId, model, 0.0, true, category);
                    break;
                case 3:
                    System.out.print("Enter load capacity (tons): ");
                    double loadCapacity = Double.parseDouble(scanner.nextLine());
                    vehicle = new Truck(vehicleId, model, 0.0, true, category, loadCapacity);
                    break;
            }

            if (vehicle != null) {
                vehicles.add(vehicle);
                System.out.println("\nVehicle added successfully!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }
    }

    private void registerNewCustomer() {
        System.out.println("\n=== Register New Customer ===");
        try {
            System.out.print("Enter Customer ID (6 digits): ");
            String customerId = scanner.nextLine();
            System.out.print("Enter Customer Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Contact Number (10 digits): ");
            String contactInfo = scanner.nextLine();

            Customer customer = new Customer(customerId, name, contactInfo);
            customers.add(customer);
            System.out.println("\nCustomer registered successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayVehiclesByType(String type) {
        System.out.println("\n=== Available " + type + "s ===");
        System.out.println("ID\t\tModel\t\tCategory\tDaily Rate");
        System.out.println("--------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().getSimpleName().equals(type) && vehicle.isAvailable()) {
                System.out.printf("%s\t%-15s\t%-10s\t$%.2f\n",
                        vehicle.getVehicleID(),
                        vehicle.getModel(),
                        vehicle.getCategory(),
                        vehicle.getBaseRentalRate());
            }
        }
    }

    private void rentVehicle() {
        if (vehicles.isEmpty() || customers.isEmpty()) {
            System.out.println("\nError: Need both vehicles and customers registered to process rentals.");
            return;
        }

        System.out.println("\n=== Rent a Vehicle ===");
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        Customer customer = findCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.println("\nSelect vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Truck");
        int typeChoice = getValidChoice(1, 3);

        String vehicleType = "";
        switch (typeChoice) {
            case 1:
                vehicleType = "Car";
                break;
            case 2:
                vehicleType = "MotorCycle";
                break;
            case 3:
                vehicleType = "Truck";
                break;
        }

        displayVehiclesByType(vehicleType);

        System.out.print("\nEnter Vehicle ID to rent: ");
        String vehicleId = scanner.nextLine();

        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle != null && vehicle.isAvailableForRental()) {
            System.out.print("Enter number of rental days: ");
            try {
                int days = Integer.parseInt(scanner.nextLine());
                double cost = vehicle.calculateRentalCost(days);
                vehicle.setAvailable(false);
                customer.startRental(vehicleType, days);
                printRentalReceipt(customer, vehicle, days, cost);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number of days.");
            }
        } else {
            System.out.println("Vehicle not available for rental!");
        }
    }

    private void printRentalReceipt(Customer customer, Vehicle vehicle, int days, double cost) {
        System.out.println("\n****************************************************");
        System.out.println("*              ALPHA VEHICLE RENTALS               *");
        System.out.println("*                 RENTAL RECEIPT                   *");
        System.out.println("****************************************************");
        System.out.println("\nRENTAL INFORMATION:");
        System.out.println("Date: " + LocalDate.now());
        System.out.println("Time: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        System.out.println("\nCUSTOMER INFORMATION:");
        System.out.println(customer.displayCustomerDetails());

        System.out.println("\nVEHICLE INFORMATION:");
        System.out.println("Vehicle ID: " + vehicle.getVehicleID());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Category: " + vehicle.getCategory());

        System.out.println("\nRENTAL DETAILS:");
        System.out.println("Rental Duration: " + days + " days");
        System.out.println("Daily Rate: $" + String.format("%.2f", vehicle.getBaseRentalRate()));
        System.out.println("----------------------------------------------------");
        System.out.println("Total Cost: $" + String.format("%.2f", cost));
        System.out.println("\nThank you for choosing Alpha Vehicle Rentals!");
        System.out.println("****************************************************");
    }

    private void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles in the system.");
            return;
        }

        System.out.println("\n=== All Vehicles ===");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    private void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("\nNo customers registered.");
            return;
        }

        System.out.println("\n=== All Customers ===");
        for (Customer customer : customers) {
            System.out.println("\n" + customer.displayCustomerDetails());
        }
    }

    private Customer findCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.displayCustomerDetails().contains(customerId)) {
                return customer;
            }
        }
        return null;
    }

    private Vehicle findVehicle(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleID().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        agency.start();
    }
}

