package basicdatastructure;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;




/** Junit test class for Bubble sort**/

public class Assignment1Q8Test {
	
	/** Junit test case for check bubble sort**/
	
    @Test
    public void testBubbleSort() {
    	final Assignment1Q8 bubbleSort = new Assignment1Q8();
        final int[] unsortedArr = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final int[] sortedArr = bubbleSort.bubbleSort(unsortedArr);

        // Expected result after sorting
        final int[] expectedResult = {1, 5, 6, 7, 12, 14, 19, 23, 26, 35, 37, 47, 52, 78, 86};

        // Verify if the array is sorted correctly
        assertArrayEquals(expectedResult, sortedArr);
    }

    /** Junit test case for emtpy array**/
    @Test
    public void testBubbleSortEmptyArray() {
    	final Assignment1Q8 bubbleSort = new Assignment1Q8();
        final int[] emptyArr = {};
        final int[] sortedArr = bubbleSort.bubbleSort(emptyArr);

        // For an empty array, the result should also be an empty array
        final int[] expectedResult = {};

        // Verify if the array is sorted correctly
        assertArrayEquals(expectedResult, sortedArr);
    }

    
}
