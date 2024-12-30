package programming1.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("CAR001", "Toyota Camry", 30.0, true, "Economy", 3);
    }

    @Test
    void testPassengerCapacityValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Car("CAR002", "Honda Accord", 30.0, true, "Economy", -1));
        assertThrows(IllegalArgumentException.class, () -> new Car("CAR003", "BMW", 30.0, true, "Economy", 6));
    }

    @Test
    void testCalculateRentalCostWithSurcharge() {
        car.setPassengerCapacity(5);
        assertEquals(120.0, car.calculateRentalCost(4)); // Base rate + surcharge
    }
}














