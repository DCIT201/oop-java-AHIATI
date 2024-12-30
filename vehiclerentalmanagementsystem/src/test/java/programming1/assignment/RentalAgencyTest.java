package programming1.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {
    private RentalAgency rentalAgency;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        rentalAgency = new RentalAgency();
    }

    @Test
    void testInitialization() {
        assertNotNull(rentalAgency, "RentalAgency should be initialized");
    }

    @Test
    void testDisplayMainMenu() {
        String input = "6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("Main Menu"));
        assertTrue(output.contains("1. Add New Vehicle"));
        assertTrue(output.contains("6. Exit"));
    }

    @Test
    void testAddNewVehicle() {
        String input = "1\nCAR999\nTest Car\nLuxury\n4\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("Vehicle added successfully"));
    }

    @Test
    void testRegisterNewCustomer() {
        String input = "2\n123456\nJohn Doe\n0123456789\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("Customer registered successfully"));
    }

    @Test
    void testRentVehicle() {
        String input = "2\n123456\nJohn Doe\n0123456789\n3\n123456\n1\nCAR001\n5\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("RENTAL INFORMATION"));
    }

    @Test
    void testDisplayAllVehicles() {
        String input = "4\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("=== All Vehicles ==="));
    }

    @Test
    void testDisplayAllCustomers() {
        String input = "5\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("=== All Customers ==="));
    }

    @Test
    void testExitProgram() {
        String input = "6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("Thank you for using Alpha Vehicle Rentals"));
    }

    @Test
    void testInvalidMenuChoice() {
        String input = "invalid\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        rentalAgency.start();
        String output = outputStream.toString();
        assertTrue(output.contains("Please enter a valid number"));
    }

    @Test
    void main() {
        assertDoesNotThrow(() -> RentalAgency.main(new String[]{}));
    }
}