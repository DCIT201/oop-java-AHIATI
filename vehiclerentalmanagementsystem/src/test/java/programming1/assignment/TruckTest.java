package programming1.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void testConstructor_validInput() {
        Truck truck = new Truck("TRK123", "Ford F-150", 70.00, true, "SUV", 2.5);
        assertNotNull(truck);
    }

    @Test
    void testConstructor_invalidLoadCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Truck("TRK123", "Ford F-150", 70.00, true, "SUV", 0.0));
        assertThrows(IllegalArgumentException.class, () -> new Truck("TRK123", "Ford F-150", 70.00, true, "SUV", -1.0));
    }

    @Test
    void testGetLoadCapacity() {
        Truck truck = new Truck("TRK123", "Ford F-150", 70.00, true, "SUV", 2.5);
        assertEquals(2.5, truck.getLoadCapacity());
    }

    @Test
    void testSetLoadCapacity_validInput() {
        Truck truck = new Truck("TRK123", "Ford F-150", 70.00, true, "SUV", 2.5);
        truck.setLoadCapacity(3.0);
        assertEquals(3.0, truck.getLoadCapacity());
    }

    @Test
    void testSetLoadCapacity_invalidInput() {
        Truck truck = new Truck("TRK123", "Ford F-150", 70.00, true, "SUV", 2.5);
        truck.setLoadCapacity(0.0);
        assertEquals(2.5, truck.getLoadCapacity()); // Load capacity should not be changed
    }

    @Test
    void testIsAvailableForRental() {
        Truck truck = new Truck("TRK123", "Ford F-150", 70.00, true, "SUV", 2.5);
        assertTrue(truck.isAvailableForRental());
    }


}







