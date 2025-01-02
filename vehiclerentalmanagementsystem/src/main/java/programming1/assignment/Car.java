package programming1.assignment;

import java.util.Scanner;
public class Car extends Vehicle {
    private int passengerCapacity;

    public Car(String vehicleID, String model, double baseRentalRate, boolean isAvailable,String category,int passengerCapacity){
        super(vehicleID,model,baseRentalRate,isAvailable,category);
        Scanner input = new Scanner(System.in);

        while(passengerCapacity <= 0 || passengerCapacity > 5){
            if(passengerCapacity < 0){
                System.out.println("Passenger capacity must be greater than zero.");
            }
            if(passengerCapacity > 5){
                System.out.println("Passenger capacity must be less than five.");
            }
            System.out.println("Please enter a valid passenger capacity between 1 and 5: ");
            passengerCapacity = input.nextInt(); // Re-prompt for valid input
        }
        this.passengerCapacity = passengerCapacity;
    }
    // Getter and setter for passengerCapacity (encapsulation)
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity){
        if(passengerCapacity <=0 || passengerCapacity >5){
            System.out.println("The Passenger capacity must be greater than zero and cannot exceed 5.");
        }
        else{
            this.passengerCapacity = passengerCapacity;
        }
    }
    @Override
    public double calculateRentalCost(int days){
        double rentalCost = getBaseRentalRate() *  days;

        if (passengerCapacity > 4 ){
            rentalCost += 20.00;
        }
        return rentalCost;
    }

    public boolean isAvailableForRental(){
        return isAvailable();
    }
    @Override
    public String toString() {
        return "Car [ID = " + getVehicleID() + ", Model = " + getModel() + ", Category = " + getCategory() +
                ", Passenger Capacity = " + passengerCapacity + ", Available = " + isAvailable() + "]";
    }
}
