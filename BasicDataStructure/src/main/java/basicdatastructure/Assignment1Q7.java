package basicdatastructure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Assignment1Q7: A class for searching values in an array.
 */
public class Assignment1Q7 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q7.class.getName());

    /**
     * Searches for a value in the given array.
     *
     * @param arr           The array to search in.
     * @param toCheckValue  The value to check in the array.
     * @return              True if the value is present, false otherwise.
     */
    public static boolean searchArray(final int[] arr, final int toCheckValue) {
        if (arr == null) {
            return false;
        }

        for (final int value : arr) {
            if (value == toCheckValue) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearchArrayValuePresent() {
        final int[] arr = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final int valueToCheck = 19;

        assertTrue(searchArray(arr, valueToCheck));
    }

    @Test
    void testSearchArrayValueNotPresent() {
        final int[] arr = {5, 12, 14, 6, 78, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final int valueToCheck = 19;

        assertFalse(searchArray(arr, valueToCheck));
    }

    @Test
    void testSearchArrayNullArray() {
        final int[] arr = null;
        final int valueToCheck = 19;

        assertFalse(searchArray(arr, valueToCheck));
    }

    @Test
    void testSearchArrayEmptyArray() {
        final int[] arr = {};
        final int valueToCheck = 19;

        assertFalse(searchArray(arr, valueToCheck));
    }

    @Test
    void testSearchArrayValueInEmptyArray() {
        final int[] arr = {};
        final int valueToCheck = 19;

        assertFalse(searchArray(arr, valueToCheck));
    }

    /**
     * Main method to demonstrate array 
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        final int[] arr = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final int valueToCheck = 19;

        final boolean isPresent = searchArray(arr, valueToCheck);

        if (isPresent) {
            logger.log(Level.INFO, valueToCheck + " is present in the array.");
        } else {
            logger.log(Level.INFO, valueToCheck + " is not present in the array.");
        }

        final int valueNotInArray = 100;
        final boolean isNotPresent = searchArray(arr, valueNotInArray);

        if (isNotPresent) {
            logger.log(Level.INFO, valueNotInArray + " is present in the array.");
        } else {
            logger.log(Level.INFO, valueNotInArray + " is not present in the array.");
        }
    }
}
