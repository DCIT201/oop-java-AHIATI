package programming1.assignment;

import java.util.Scanner;

public class Truck extends Vehicle{
    private double loadCapacity;

    public Truck(String vehicleID, String model, double baseRentalRate, boolean isAvailable,String category,double loadCapacity){
        super(vehicleID,model,baseRentalRate,isAvailable,category);

        Scanner input = new Scanner(System.in);

        while(loadCapacity <= 0){
            System.out.println("The load Capacity cannot be less or equal to zero.");
            System.out.println("Please enter a new input ");

            loadCapacity = input.nextDouble();
        }
        this.loadCapacity = loadCapacity;
    }
    // Getter for loadCapacity
    public double getLoadCapacity() {
        return loadCapacity;
    }

    // Setter for loadCapacity with validation
    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity <= 0) {
            System.out.println("Load capacity must be greater than zero.");
        } else {
            this.loadCapacity = loadCapacity;
        }
    }
    // Override calculateRentalCost to include load capacity in the pricing
    @Override
    public double calculateRentalCost(int days) {
        double rentalCost = getBaseRentalRate() * days;

        // Apply surcharge based on load capacity (example: $30 surcharge for each ton)
        rentalCost += loadCapacity * 30.00;

        return rentalCost;
    }

    // Override isAvailableForRental to check availability
    @Override
    public boolean isAvailableForRental() {
        return isAvailable();  // Returns availability from the parent class
    }

    // Override toString method for truck-specific output
    @Override
    public String toString() {
        return "Truck [ID=" + getVehicleID() + ", Model=" + getModel() + ", Category=" + getCategory() +
                ", Load Capacity=" + loadCapacity + " tons, Available=" + isAvailable() + "]";
    }
}
