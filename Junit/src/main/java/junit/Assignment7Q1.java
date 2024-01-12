package junit;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * A class that contains a method to find the minimum and maximum values in an array.
 */
public class Assignment7Q1 {

    /**
     * Finds the minimum and maximum values in the given array.
     * 
     * @param arr The input array.
     * @return An array containing the minimum and maximum values.
     * @throws IllegalArgumentException if the input array is empty or null.
     */
    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array should not be empty or null");
        }

        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        return new int[]{min, max};
    }

    /**
     * Test method to validate the functionality of the findMinMax method.
     */
    @Test
    public void testFindMinMax() {
        // Test Case 1
        int[] result1 = Assignment7Q1.findMinMax(new int[]{56, 34, 7, 3, 54, 3, 34, 34, 53});
        assertArrayEquals(new int[]{3, 56}, result1);

        // Test Case 2
        int[] result2 = Assignment7Q1.findMinMax(new int[]{10, 20, 30, 40, 50});
        assertArrayEquals(new int[]{10, 50}, result2);

        // Test Case 3
        int[] result3 = Assignment7Q1.findMinMax(new int[]{5, 5, 5, 5, 5});
        assertArrayEquals(new int[]{5, 5}, result3);

        // Additional Test Case 4
        int[] result4 = Assignment7Q1.findMinMax(new int[]{-10, -5, 0, 5, 10});
        assertArrayEquals(new int[]{-10, 10}, result4);
    }

    /**
     * Main method to run the JUnit tests.
     * 
     * @param args Command line arguments (not used).
     */
    
    public static void main(String[] args) {
        // Run the JUnit tests
        org.junit.runner.JUnitCore.main("junit.Assignment7Q1");
    }
}
