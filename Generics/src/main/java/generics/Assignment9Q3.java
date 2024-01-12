package generics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Utility class for swapping elements in an array.
 */
public class Assignment9Q3 {

    private static final Logger logger = Logger.getLogger(Assignment9Q3.class.getName());

    /**
     * JUnit test case for swapElement.
     */
    @Test
    void testSwapElements() {
        // Test swapping elements in an Integer array
        final Integer[] integerArray = {1, 2, 3, 4, 5};
        Assignment9Q3.swapElements(integerArray, 1, 3);
        final Integer[] expectedIntegerArray = {1, 4, 3, 2, 5};
        assertArrayEquals(expectedIntegerArray, integerArray, "Integer array should be swapped");

        // Test swapping elements in a String array
        final String[] stringArray = {"apple", "banana", "orange", "grape"};
        Assignment9Q3.swapElements(stringArray, 0, 2);
        final String[] expectedStringArray = {"orange", "banana", "apple", "grape"};
        assertArrayEquals(expectedStringArray, stringArray, "String array should be swapped");
    }

    /**
     * Swaps elements at the specified indices in the given array.
     *
     * @param array  The array in which elements will be swapped.
     * @param index1 The index of the first element to be swapped.
     * @param index2 The index of the second element to be swapped.
     * @param <T>    The type of elements in the array.
     */
    public static <T> void swapElements(final T[] array, final int index1, final int index2) {
        if (isValidIndices(array, index1, index2)) {
            final T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
            logger.log(Level.INFO, "Swapped elements at indices " + index1 + " and " + index2);
        } else {
            logger.log(Level.WARNING, "Invalid indices. Cannot swap elements.");
        }
    }

    /**
     * Checks if the specified indices are valid for the given array.
     *
     * @param array  The array in which elements will be swapped.
     * @param index1 The index of the first element to be swapped.
     * @param index2 The index of the second element to be swapped.
     * @param <T>    The type of elements in the array.
     * @return True if indices are valid, false otherwise.
     */
    private static <T> boolean isValidIndices(final T[] array, final int index1, final int index2) {
        return index1 >= 0 && index1 < array.length && index2 >= 0 && index2 < array.length;
    }

    /**
     * The main method of the program responsible for user input, division calculation,
     * and displaying the result or an error message.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        // Example usage
        final Integer[] integerArray = {1, 2, 3, 4, 5};
        logger.log(Level.INFO, "Original array: " + Arrays.toString(integerArray));

        // Swap elements at indices 1 and 3
        Assignment9Q3.swapElements(integerArray, 1, 3);
        logger.log(Level.INFO, "Array after swapping: " + Arrays.toString(integerArray));

        // String array example
        final String[] stringArray = {"apple", "banana", "orange", "grape"};
        logger.log(Level.INFO, "Original array: " + Arrays.toString(stringArray));

        // Swap elements at indices 0 and 2
        Assignment9Q3.swapElements(stringArray, 0, 2);
        logger.log(Level.INFO, "Array after swapping: " + Arrays.toString(stringArray));
    }
}
