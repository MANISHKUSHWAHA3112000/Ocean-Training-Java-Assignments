package basicdatastructure;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Assignment1Q2: Utility class for working with Armstrong numbers.
 */
public final class Assignment1Q2 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q2.class.getName());

    // Private constructor to prevent instantiation
    
    public Assignment1Q2() {
       
    }

    /**
     * Checks if a given number is an Armstrong number.
     *
     * @param num The number to check.
     * @return True if the number is an Armstrong number, false otherwise.
     */
    public static boolean isArmstrongNumber(int num) {
        final int originalNum = num;
        int sum = 0;

        while (num != 0) {
            final int rem = num % 10;
            sum += (rem * rem * rem);
            num = num / 10;
        }

        return sum == originalNum;
    }

    /**
     * Prints Armstrong numbers in the specified range.
     *
     * @param start The start of the range.
     * @param end   The end of the range.
     */
    public static void printArmstrongNumbersInRange(final int start, final int end) {
        if (start <= 0 || end <= 0 || start > end) {
            logger.log(Level.INFO, "Invalid input range. Please provide valid positive integers.");
            return;
        }

        logger.log(Level.INFO, "Armstrong numbers in the range " + start + " to " + end + ":");

        for (int i = start; i <= end; i++) {
            if (isArmstrongNumber(i)) {
                logger.log(Level.INFO, String.valueOf(i));
            }
        }
    }

    /**
     * JUnit test for the printArmstrongNumbersInRange method.
     */
    @Test
    public void testPrintArmstrongNumbersInRange() {
        // Test with a valid range
        Assignment1Q2.printArmstrongNumbersInRange(100, 999);

        // Test with an invalid range (start > end)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        Assignment1Q2.printArmstrongNumbersInRange(999, 100);

        // Test with an invalid range (negative start)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        Assignment1Q2.printArmstrongNumbersInRange(-100, 999);

        // Test with an invalid range (negative end)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        Assignment1Q2.printArmstrongNumbersInRange(100, -999);

        // Test with an invalid range (both negative)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        Assignment1Q2.printArmstrongNumbersInRange(-100, -999);

        // Test with an invalid range (both zero)
        logger.log(Level.INFO, "Expected: Invalid input range. Please provide valid positive integers.");
        Assignment1Q2.printArmstrongNumbersInRange(0, 0);
    }

    /**
     * Main method to demonstrate the usage of Armstrong number utility methods.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        final int num1 = 100;
        final int num2 = 999;

        // Print Armstrong numbers in the specified range
        printArmstrongNumbersInRange(num1, num2);
    }
}
