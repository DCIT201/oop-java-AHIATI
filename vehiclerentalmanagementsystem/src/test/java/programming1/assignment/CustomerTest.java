package programming1.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("123456", "John Doe", "0123456789");
    }

    @Test
    void testCustomerIdValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Customer("12345A", "Jane Doe", "0123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Customer("12345", "Jane Doe", "0123456789"));
    }

    @Test
    void testNameValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Customer("123456", "", "0123456789"));
    }

    @Test
    void testContactInfoValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Customer("123456", "Jane Doe", "01234567"));
        assertThrows(IllegalArgumentException.class, () -> new Customer("123456", "Jane Doe", "01234567890"));
    }

    @Test
    void testStartRental() {
        customer.startRental("Car", 5);
        assertTrue(customer.displayCustomerDetails().contains("Car rental for 5 days"));
    }
}
