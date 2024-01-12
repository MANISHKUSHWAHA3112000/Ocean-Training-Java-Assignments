package basicdatastructure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;




/** junit test class for search array in given array**/

class Assignment1Q7Test {
	
	
   /** Junit test case for value present**/
    @Test
    void testSearchArrayValuePresent() {
        final int[] arr = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final int valueToCheck = 19;

        assertTrue(Assignment1Q7.searchArray(arr, valueToCheck));
    }
    
    /** junit test case for value not present**/

    @Test
    void testSearchArrayValueNotPresent() {
        final int[] arr = {5, 12, 14, 6, 78, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        final int valueToCheck = 19;

        assertFalse(Assignment1Q7.searchArray(arr, valueToCheck));
    }

    /** junit test case for null array**/
    @Test
    void testSearchArrayNullArray() {
        final int[] arr = null;
        final int valueToCheck = 19;

        assertFalse(Assignment1Q7.searchArray(arr, valueToCheck));
    }

    /** junit test case for empty array**/
    @Test
    void testSearchArrayEmptyArray() {
        final int[] arr = {};
        final int valueToCheck = 19;

        assertFalse(Assignment1Q7.searchArray(arr, valueToCheck));
    }

    /** junit test case for value empty array**/
    @Test
    void testSearchArrayValueInEmptyArray() {
        final int[] arr = {};
        final int valueToCheck = 19;

        assertFalse(Assignment1Q7.searchArray(arr, valueToCheck));
    }
}
