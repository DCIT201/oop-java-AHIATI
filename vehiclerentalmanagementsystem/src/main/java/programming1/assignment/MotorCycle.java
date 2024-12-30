

package programming1.assignment;

import java.util.Scanner;

class MotorCycle extends Vehicle {
    // Constructor for MotorCycle
    public MotorCycle(String vehicleID, String model, double baseRentalRate, boolean isAvailable, String category) {
        super(vehicleID, model, baseRentalRate, isAvailable, category);

        Scanner input = new Scanner(System.in);

        // Validation for vehicleID (already handled in Vehicle class constructor)

        // Validation for model (already handled in Vehicle class constructor)

        // Validation for category (already handled in Vehicle class constructor)

        // No sidecar question, as it's removed
    }

    // Method to calculate rental cost based on rental days
    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days; // No sidecar surcharge anymore
    }

    // Override to check if motorcycle is available for rental
    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Return availability from the parent class
    }

    // Override toString for motorcycle-specific output
    @Override
    public String toString() {
        return "MotorCycle [ID=" + getVehicleID() + ", Model=" + getModel() + ", Category=" + getCategory() +
                ", Available=" + isAvailable() + "]";
    }
}












