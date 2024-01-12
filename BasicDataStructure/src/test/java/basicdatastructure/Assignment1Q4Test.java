package basicdatastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test class for Assignment1Q4.
 */
public class Assignment1Q4Test {

    /**
     * Constructor for Assignment1Q4Test.
     */
    public Assignment1Q4Test() {
        // Any setup logic for the test class can go here
    }

    @Test
    public void testDeclareResult() {
        /** Test case 1: All subjects marks greater than 60 should return "Passed"**/
        assertEquals("Passed", ResultUtility.declareResult(70, 75, 80));

        /**  Test case 2: Any two subjects marks greater than 60 should return "Promoted"**/
        assertEquals("Promoted", ResultUtility.declareResult(70, 75, 50));

        /**  Test case 3: Any one subject mark greater than 60 should return "Promoted"**/
        assertEquals("Promoted", ResultUtility.declareResult(70, 55, 45));

        /**  Test case 4: All subjects marks less than or equal to 60 should return "Failed"**/
        assertEquals("Failed", ResultUtility.declareResult(40, 55, 45));

        /**  Test case 5: Mixed conditions, should return "Promoted"**/
        assertEquals("Promoted", ResultUtility.declareResult(55, 65, 50));

        /**  Additional Test case 6: All subjects marks exactly 60 should return "Failed"**/
        assertEquals("Failed", ResultUtility.declareResult(60, 60, 60));
    }
}
