package programming1.assignment;

class Customer {
    private String customerId;
    private String name;
    private String contactInfo;
    private String rentalStatus;

    // Constructor with validations
    public Customer(String customerId, String name, String contactInfo) {
        // Validate customer ID
        if (customerId.length() == 6 && customerId.matches("[0-9]+")) {
            this.customerId = customerId;
        } else {
            throw new IllegalArgumentException("Customer ID must be exactly 6 digits.");
        }

        // Validate name
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        // Validate contact info (10 digits)
        if (contactInfo.length() == 10 && contactInfo.matches("[0-9]+")) {
            this.contactInfo = contactInfo;
        } else {
            throw new IllegalArgumentException("Contact Info must be exactly 10 digits.");
        }

        // Initialize rentalStatus as empty initially
        this.rentalStatus = "No rental selected yet.";
    }

    // Method to start rental
    public void startRental(String vehicleType, int rentalDays) {
        if (vehicleType != null && !vehicleType.trim().isEmpty()) {
            this.rentalStatus = vehicleType + " rental for " + rentalDays + " days";
        } else {
            this.rentalStatus = "No vehicle selected.";
        }
    }

    // Method to display customer details
    public String displayCustomerDetails() {
        return "Customer ID: " + this.customerId +
                "\nName: " + this.name +
                "\nContact Info: " + this.contactInfo +
                "\nRental Status: " + this.rentalStatus;
    }
}
