package basicdatastructure;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Assignment1Q4: Utility class for declaring results based on subject marks.
 */
public final class Assignment1Q4 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q4.class.getName());

    private Assignment1Q4() {
        // Private constructor to prevent instantiation (utility class)
    }

    /**
     * Constructor for Assignment1Q4Test.
     */
    public void Assignment1Q4Test() {
        // Any setup logic for the test class can go here
    }

    /** Test method for declare Result which id greater than 60 **/
    @Test
    public void testDeclareResult() {
        // Test case 1: All subjects marks greater than 60 should return "Passed"
        assertEquals("Passed", ResultUtility.declareResult(70, 75, 80));

        // Test case 2: Any two subjects marks greater than 60 should return "Promoted"
        assertEquals("Promoted", ResultUtility.declareResult(70, 75, 50));

        // Test case 3: Any one subject mark greater than 60 should return "Promoted"
        assertEquals("Promoted", ResultUtility.declareResult(70, 55, 45));

        // Test case 4: All subjects marks less than or equal to 60 should return "Failed"
        assertEquals("Failed", ResultUtility.declareResult(40, 55, 45));

        // Test case 5: Mixed conditions, should return "Promoted"
        assertEquals("Promoted", ResultUtility.declareResult(55, 65, 50));

        // Additional Test case 6: All subjects marks exactly 60 should return "Failed"
        assertEquals("Failed", ResultUtility.declareResult(60, 60, 60));
    }

    /**
     * Main method to take input for subject marks and declare the result.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        try {
            logger.log(Level.INFO, "Enter marks for subject 1:");
            final int subject1 = scanner.nextInt();

            logger.log(Level.INFO, "Enter marks for subject 2:");
            final int subject2 = scanner.nextInt();

            logger.log(Level.INFO, "Enter marks for subject 3:");
            final int subject3 = scanner.nextInt();

            final String result = ResultUtility.declareResult(subject1, subject2, subject3);
            logger.log(Level.INFO, "Result: " + result);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        } finally {
            scanner.close(); // Closing the Scanner resource
        }
    }
}

/**
 * Utility class for declaring results based on subject marks.
 */
final class ResultUtility {

    private ResultUtility() {
        // Private constructor to prevent instantiation (utility class)
    }

    /**
     * Declares the result based on subject marks.
     *
     * @param subject1 Marks for subject 1.
     * @param subject2 Marks for subject 2.
     * @param subject3 Marks for subject 3.
     * @return Result string indicating "Passed," "Promoted," or "Failed."
     */
    public static String declareResult(final int subject1, final int subject2, final int subject3) {
        final boolean allSubjectsPassed = isAllSubjectsPassed(subject1, subject2, subject3);
        final boolean anySubjectPromoted = isAnySubjectPromoted(subject1, subject2, subject3);

        String result;
        if (allSubjectsPassed) {
            result = "Passed";
        } else if (anySubjectPromoted) {
            result = "Promoted";
        } else {
            result = "Failed";
        }

        return result; // Only one exit point at the end of the method
    }

    private static boolean isAllSubjectsPassed(final int subject1, final int subject2, final int subject3) {
        return subject1 > 60 && subject2 > 60 && subject3 > 60;
    }

    private static boolean isAnySubjectPromoted(final int subject1, final int subject2, final int subject3) {
        return subject1 > 60 || subject2 > 60 || subject3 > 60;
    }
}
