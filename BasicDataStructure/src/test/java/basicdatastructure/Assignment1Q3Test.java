package basicdatastructure;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * JUnit test class for Assignment1Q3.
 */
public class Assignment1Q3Test {

    
    /**
     * Tests the simpleInterest method.
     */
    @Test
    public void testSimpleInterest() {
        // Given
        final double principal = 10_000;
        final int time = 3;
        final double rate = 2;

        // When
        final double result = Assignment1Q3.simpleInterest(principal, time, rate);

        // Then
        assertEquals("Simple Interest calculation is incorrect", 600, result, 0.001);
    }

    /**
     * Tests the compoundInterest method.
     */
    @SuppressWarnings("deprecation")
	@Test
    public void testCompoundInterest() {
        // Given
        final double principal = 10_000;
        final int time = 3;
        final double rate = 2;

        // When
        BigDecimal actual = new BigDecimal(Assignment1Q3.compoundInterest(principal, time, rate));
         actual = actual.setScale(2, BigDecimal.ROUND_HALF_UP);

        // Then
        final BigDecimal expected = new BigDecimal("612.08");
        assertEquals("Compound Interest calculation is incorrect", expected, actual);
    }
}
