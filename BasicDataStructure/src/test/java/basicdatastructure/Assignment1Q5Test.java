package basicdatastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Assignment1Q5Test: JUnit test class for Assignment1Q5.
 */
public class Assignment1Q5Test {

    /**
     * Test case for the calculateTax method in Assignment1Q5.
     */
	 @Test
	    public void testCalculateTax() {
	       

	        /** Test case 1: Income within the range [0, 180,000], 
	         * should return 0.0**/
	        assertEquals(0.0, Assignment1Q5.calculateTax(150000), 0.001);

	         /** Test case 2: Income within the range (180,001, 300,000],
	          *  should return 10% of income
	          */
	        assertEquals(25_000.0, Assignment1Q5.calculateTax(250000), 0.001);

	         /** Test case 3: Income within the range (300,001, 500,000],
	          *  should return 20% of income
	          */
	        assertEquals(30_000.0, Assignment1Q5.calculateTax(300000), 0.001);

	         /** Test case 4: Income within the range (500,001, 1,000,000],
	          *  should return 30% of income
	          */
	        assertEquals(180_000.0, Assignment1Q5.calculateTax(600000), 0.001);

	         /** Test case 5: Income greater than 1,000,000, 
	          * should return 0.0
	          */
	        assertEquals(0.0, Assignment1Q5.calculateTax(1_200_000), 0.001);
	    
	 
	}
}
