package basicdatastructure;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This class provides functionality to check 
 * if a given number is an Armstrong number.
 */
public class Assignment1Q1 {

    /** Logger for logging messages **/
    private static final Logger logger = Logger.getLogger(Assignment1Q1.class.getName());

    /** Scanner to take user input **/
    private final Scanner scanner;

    /** Default constructor to initialize the scanner **/
    public Assignment1Q1() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Checks if a given number is an Armstrong number.
     *
     * @param num The number to be checked.
     * @return True if the number is an Armstrong number, false otherwise.
     */
    public static boolean isArmstrong(final int num) {
        if (num < 0) {
            return false;
        }

        int result = 0;
        final int originalNum = num;

        int tempNum = num;
        while (tempNum != 0) {
            final int digit = tempNum % 10;
            result += Math.pow(digit, 3);
            tempNum /= 10;
        }

        return result == originalNum || (originalNum >= 0 && originalNum <= 9);
    }

    /**
     * Gets user input for a non-negative number.
     *
     * @return The non-negative number entered by the user.
     */
    public int getUserInput() {
        int num;
        do {
            logger.log(Level.INFO, "Enter a non-negative number: ");
            num = scanner.nextInt();

            if (num < 0) {
                logger.log(Level.WARNING, "Please enter a non-negative number.");
            }
        } while (num < 0);

        return num;
    }

    /**
     * Checks if a given number is an Armstrong number and
     *  returns a descriptive string.
     *
     * @param num The number to be checked.
     * @return A string indicating whether 
     * the number is an Armstrong number or not.
     */
    public String checkArmstrongNumber(final int num) {
        return isArmstrong(num) ? num + " is an Armstrong number" : num + " is not an Armstrong number";
    }

    /**
     * JUnit test case for the isArmstrong method.
     * It includes multiple assertions and a single exit point.
     */
    @Test
    public void testIsArmstrong() {
        final int[] armstrongNumbers = { 153, 0, 5, 371 };
        final int[] nonArmstrongNumbers = { 123, -370 };

        for (final int armstrong : armstrongNumbers) {
            assertTrue(armstrong + " should be an Armstrong number", isArmstrong(armstrong));
        }

        for (final int nonArmstrong : nonArmstrongNumbers) {
            assertFalse(nonArmstrong + " should not be an Armstrong number", isArmstrong(nonArmstrong));
        }
    }

    /**
     * Main method to execute the Armstrong number checking program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        final Assignment1Q1 armstrongChecker = new Assignment1Q1();
        final int num = armstrongChecker.getUserInput();
        logger.log(Level.INFO, armstrongChecker.checkArmstrongNumber(num));
    }
}
