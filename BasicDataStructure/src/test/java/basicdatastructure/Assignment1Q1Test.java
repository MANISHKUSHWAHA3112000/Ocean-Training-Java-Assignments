package basicdatastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class Assignment1Q1Test {

    @Test
    public void testIsArmstrong() {
        // Test for an Armstrong number (e.g., 153)
        assertTrue(Assignment1Q1.isArmstrong(153));

        // Test for a non-Armstrong number
        assertFalse(Assignment1Q1.isArmstrong(123));

        // Test for 0 (0 is an Armstrong number)
        assertTrue(Assignment1Q1.isArmstrong(0));

        // Test for a single-digit Armstrong number (e.g., 5)
        assertTrue(Assignment1Q1.isArmstrong(5));

        // Test for a negative number (should return false)
        assertFalse(Assignment1Q1.isArmstrong(-370));

        // Test for a three-digit Armstrong number (e.g., 371)
        assertTrue(Assignment1Q1.isArmstrong(371));
    }
}
