package basicdatastructure;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * This class implements the Bubble Sort algorithm and
 * provides methods to sort an array.
 */
public class Assignment1Q8 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q8.class.getName());

    /**
     * Sorts an array using the Bubble Sort algorithm.
     *
     * @param array The array to be sorted.
     * @return The sorted array.
     */
    public int[] bubbleSort(final int[] array) {
        final int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    final int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // Use Arrays.copyOf to create a copy of the array before returning
        return Arrays.copyOf(array, length);
    }

    /**
     * Tests the Bubble Sort algorithm with a sample unsorted array.
     */
    @Test
    public void testBubbleSort() {
        final Assignment1Q8 bubbleSort = new Assignment1Q8();
        final int[] unsortedArray = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final int[] sortedArray = bubbleSort.bubbleSort(unsortedArray);

        // Expected result after sorting the array
        final int[] expectedResult = {1, 5, 6, 7, 12, 14, 19, 23, 26, 35, 37, 47, 52, 78, 86};

        assertArrayEquals(expectedResult, sortedArray);
    }

    /**
     * Tests the Bubble Sort algorithm with an empty array.
     */
    @Test
    public void testBubbleSortEmptyArray() {
        final Assignment1Q8 bubbleSort = new Assignment1Q8();
        final int[] emptyArray = {};
        final int[] sortedArray = bubbleSort.bubbleSort(emptyArray);

        // Expected result for an empty array (should remain empty)
        final int[] expectedResult = {};

        assertArrayEquals(expectedResult, sortedArray);
    }

    /**
     * Main method to demonstrate the usage of the Bubble Sort algorithm.
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(final String args[]) {
        final int inputArray[] = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final Assignment1Q8 bubbleSort = new Assignment1Q8();
        final int[] sortedArray = bubbleSort.bubbleSort(inputArray);

        // Log the sorted array
        logger.log(Level.INFO, "Sorted Array: " + Arrays.toString(sortedArray));
    }
}
