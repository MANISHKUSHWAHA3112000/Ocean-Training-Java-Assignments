package basicdatastructure;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Assignment1Q2Test {

    private static final Logger logger = Logger.getLogger(Assignment1Q2.class.getName());

    @Test
    void testPrintArmstrongNumbersInRange() {
        // Test with a valid range
        logger.log(Level.INFO, "Armstrong numbers in the range 100 to 999:");
        assertDoesNotThrow(() -> Assignment1Q2.printArmstrongNumbersInRange(100, 999));

        // Test with an invalid range (start > end)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        assertDoesNotThrow(() -> Assignment1Q2.printArmstrongNumbersInRange(999, 100));

        // Test with an invalid range (negative start)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        assertDoesNotThrow(() -> Assignment1Q2.printArmstrongNumbersInRange(-100, 999));

        // Test with an invalid range (negative end)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        assertDoesNotThrow(() -> Assignment1Q2.printArmstrongNumbersInRange(100, -999));

        // Test with an invalid range (both negative)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        assertDoesNotThrow(() -> Assignment1Q2.printArmstrongNumbersInRange(-100, -999));

        // Test with an invalid range (both zero)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        assertDoesNotThrow(() -> Assignment1Q2.printArmstrongNumbersInRange(0, 0));
    }
}
