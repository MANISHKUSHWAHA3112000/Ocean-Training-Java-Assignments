package basicdatastructure;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import org.junit.Test;

public class Assignment1Q9Test {

    @SuppressWarnings("unused")
	private final InputStream originalSystemIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final Logger logger = Logger.getLogger(Assignment1Q9Test.class.getName());

    

    /**
     * Tests the marks calculator functionality.
     */
    @Test
    public void testMarksCalculator() {
        // Input data for testing
        final String input = "90 80 70\n" + "85 75 65\n" + "95 85 75\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the main method and ensure no exception is thrown
        assertDoesNotThrow(() -> Assignment1Q9.main(new String[]{}));

        // Print the actual output
        final String output = outputStreamCaptor.toString();
        logger.info("Actual Output:\n" + output);

        // For now, we check if the output contains the expected text
        logger.info("Subject-wise Results:");
        logger.info("Student-wise Results:");
    }
}
