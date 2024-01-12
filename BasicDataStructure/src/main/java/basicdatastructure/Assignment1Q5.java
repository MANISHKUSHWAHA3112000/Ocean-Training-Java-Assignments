package basicdatastructure;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * Assignment1Q5: Utility class for calculating income tax based on CTC.
 */
public class Assignment1Q5 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q5.class.getName());

    /**
     * Calculates income tax based on the Cost to Company (CTC).
     *
     * @param ctc The Cost to Company.
     * @return Income tax calculated based on the provided CTC.
     */
    public static double calculateTax(final int ctc) {
        double tax = 0.0;

        if (ctc > 0) {
            if (ctc <= 180_000) {
                // No tax for CTC up to 180,000
                tax = 0.0;
            } else if (ctc <= 300_000) {
                // 10% tax for CTC between 180,001 and 300,000
                tax = ctc * 0.1;
            } else if (ctc <= 500_000) {
                // 20% tax for CTC between 300,001 and 500,000
                tax = ctc * 0.2;
            } else if (ctc <= 1_000_000) {
                // 30% tax for CTC between 500,001 and 1,000,000
                tax = ctc * 0.3;
            }
            // Additional conditions can be added as needed
        }

        return tax;
    }

    /**
     * JUnit test for the calculateTax method.
     */
    @Test
    public void testCalculateTax() {
        assertEquals(0.0, Assignment1Q5.calculateTax(150_000), 0.001);
        assertEquals(25_000.0, Assignment1Q5.calculateTax(250_000), 0.001);
        assertEquals(30_000.0, Assignment1Q5.calculateTax(300_000), 0.001);
        assertEquals(180_000.0, Assignment1Q5.calculateTax(600_000), 0.001);
        assertEquals(0.0, Assignment1Q5.calculateTax(1_200_000), 0.001);
    }

    /**
     * Main method to take input for CTC and calculate income tax.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        try {
            logger.log(Level.INFO, "Enter your CTC (Cost to Company): ");
            final int ctc = scanner.nextInt();

            final double tax = calculateTax(ctc);
            logger.log(Level.INFO, "Income Tax: " + tax);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
