package basicdatastructure;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * Assignment1Q3: Utility class for calculating simple and compound interest.
 */
public final class Assignment1Q3 {
	
	public Assignment1Q3() {}

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q3.class.getName());

    

    /**
     * Calculates simple interest.
     *
     * @param principal The principal amount.
     * @param time      The time period in years.
     * @param rate      The interest rate per annum.
     * @return The simple interest.
     */
    public static double simpleInterest(final double principal, final int time, final double rate) {
        return (principal * rate * time) / 100;
    }

    /**
     * Calculates compound interest.
     *
     * @param principal The principal amount.
     * @param time      The time period in years.
     * @param rate      The interest rate per annum.
     * @return The compound interest.
     */
    public static double compoundInterest(final double principal, final int time, final double rate) {
        return principal * Math.pow(1 + rate / 100, time) - principal;
    }

    /**
     * Tests the simpleInterest method.
     */
    @Test
    public void testSimpleInterest() {
        final double principal = 10_000;
        final int time = 3;
        final double rate = 2;

        assertEquals("Simple Interest calculation is incorrect", 600, Assignment1Q3.simpleInterest(principal, time, rate), 0.001);
        logger.log(Level.INFO, "Simple Interest: " + Assignment1Q3.simpleInterest(principal, time, rate));
    }

    /**
     * Tests the compoundInterest method.
     */
    @Test
    public void testCompoundInterest() {
        final double principal = 10_000;
        final int time = 3;
        final double rate = 2;

        final BigDecimal expected = new BigDecimal("612.08");
        @SuppressWarnings("deprecation")
		final BigDecimal actual = new BigDecimal(Assignment1Q3.compoundInterest(principal, time, rate)).setScale(2, BigDecimal.ROUND_HALF_UP);

        assertEquals("Compound Interest calculation is incorrect", expected, actual);
        logger.log(Level.INFO, "Compound Interest: " + actual);
    }

    /**
     * Main method to demonstrate interest calculations.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        // Use underscores to separate every third digit in the principal variable
        final double principal = 10_000;
        final int time = 3;
        final double rate = 2;

        logger.log(Level.INFO, "Simple Interest: " + simpleInterest(principal, time, rate));
        logger.log(Level.INFO, "Compound Interest: " + compoundInterest(principal, time, rate));
    }
}
