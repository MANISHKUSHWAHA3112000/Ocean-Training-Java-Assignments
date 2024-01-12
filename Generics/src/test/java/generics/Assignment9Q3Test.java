package generics;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;


/** Junit test class for swapping element in array**/
class Assignment9Q3Test {
	
	

	/** junit test case for swapElement**/
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
}
