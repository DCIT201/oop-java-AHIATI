package programming1.assignment;

    import java.util.Locale;
    import java.util.Scanner;

public abstract class Vehicle {

        private String vehicleID;
        private String model;
        private double baseRentalRate;
        private boolean isAvailable;
        private String category;

        public Vehicle(String vehicleID, String model, double baseRentalRate, boolean isAvailable,String category){

            Scanner input = new Scanner(System.in);

            while(vehicleID == null || vehicleID.trim().isEmpty() || !vehicleID.trim().matches("[a-zA-Z0-9]+")){
                // The Code prompt the user to enter a valid vehicle ID if the Vehicle ID was wrong
                System.out.println("Your Vehicle ID is invalid. Please enter a valid vehicle ID (letters and numbers only): ");
                vehicleID = input.nextLine(); //Reads new input from the user
            }
            // Once valid input is entered, set the vehicleId
            this.vehicleID = vehicleID.trim();

            //Code to check for non-emptyness of the model name;
            while(model == null || model.trim().isEmpty()){
                System.out.println("The Model name cannot be empty. Please enter a valid model name: ");
                model= input.nextLine();
            }
            this.model = model;

            while(category == null || category.trim().isEmpty() || !isValidCategory(category)){
                System.out.println("You have written  an invalid category. \n The car can be either a 'Luxury','Economy' or a 'SUV'");
                category = input.nextLine();
            }
            this.category = category.trim();

            // Validate baseRentalRate based on the category
            this.baseRentalRate = getBaseRentalRateForCategory(category);

            // Set availability of vehicle (true by default)
            this.isAvailable = isAvailable;
        }

        // Method to validate if the category is valid (Luxury, Economy, SUV)
        private boolean isValidCategory(String category) {
            return category.equalsIgnoreCase("Luxury") || category.equalsIgnoreCase("Economy") || category.equalsIgnoreCase("SUV");
        }

        // Method to calculate the base rental rate based on category
        private double getBaseRentalRateForCategory(String category){
            switch (category.toLowerCase()) {
                case "Luxury":
                    return 50.00;// as the baseRentalRate on a luxury car

                case "Economy":
                    return 30.00;// as the baseRentalRate on an economy car

                case "SUV":
                    return 70.00; // as the baseRentalRate on a SUV car

                default:
                    return 10.00;
            }
        }

        // Abstract methods for calculating rental cost and availability (to be implemented in concrete classes)
        public abstract double calculateRentalCost(int days);

        public abstract boolean isAvailableForRental();

        // Getters
        public String getVehicleID() {
            return vehicleID;
        }

        public String getModel() {
            return model;
        }

        public double getBaseRentalRate() {
            return baseRentalRate;
        }

        public boolean isAvailable() { return
                isAvailable;
        }

        public String getCategory() {
            return category;
        }

        // Setters
        public void setVehicleID(String vehicleID) {
            this.vehicleID = vehicleID;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setBaseRentalRate(double baseRentalRate) {
            this.baseRentalRate = baseRentalRate;
        }

        public void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

        public void setCategory(String category) {
            this.category = category;
        }



    }



