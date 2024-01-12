package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A class that contains a method to find the minimum and maximum values in an array
 * and a nested class representing the result with min and max values.
 */
public class Assignment7Q2 {

    /**
     * A nested class representing the result of the findMinMax method with min and max values.
     */
    public static class MinMaxResult {
        private int min;
        private int max;

        /**
         * Constructor for MinMaxResult.
         * 
         * @param min The minimum value.
         * @param max The maximum value.
         */
        public MinMaxResult(int min, int max) {
            this.min = min;
            this.max = max;
        }

        /**
         * Gets the minimum value.
         * 
         * @return The minimum value.
         */
        public int getMin() {
            return min;
        }

        /**
         * Gets the maximum value.
         * 
         * @return The maximum value.
         */
        public int getMax() {
            return max;
        }
    }

    /**
     * Finds the minimum and maximum values in the given array.
     * 
     * @param arr The input array.
     * @return An instance of MinMaxResult containing the minimum and maximum values.
     * @throws IllegalArgumentException if the input array is empty or null.
     */
    public static MinMaxResult findMinMax(int[] arr) {
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

        return new MinMaxResult(min, max);
    }

    /**
     * Test method to validate the functionality of the findMinMax method.
     */
    @Test
    public void testFindMinMax() {
        // Test Case 1
        MinMaxResult result1 = Assignment7Q2.findMinMax(new int[]{56, 34, 7, 3, 54, 3, 34, 34, 53});
        assertEquals(3, result1.getMin());
        assertEquals(56, result1.getMax());

        // Test Case 2
        MinMaxResult result2 = Assignment7Q2.findMinMax(new int[]{10, 20, 30, 40, 50});
        assertEquals(10, result2.getMin());
        assertEquals(50, result2.getMax());

        // Test Case 3
        MinMaxResult result3 = Assignment7Q2.findMinMax(new int[]{5, 5, 5, 5, 5});
        assertEquals(5, result3.getMin());
        assertEquals(5, result3.getMax());

        // Additional Test Case 4
        MinMaxResult result4 = Assignment7Q2.findMinMax(new int[]{-10, -5, 0, 5, 10});
        assertEquals(-10, result4.getMin());
        assertEquals(10, result4.getMax());
    }

    /**
     * Main method to run the JUnit tests.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Run the JUnit tests
        org.junit.runner.JUnitCore.main("junit.Assignment7Q1Test");
    }
}
