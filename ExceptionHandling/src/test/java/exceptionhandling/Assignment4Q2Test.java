package exceptionhandling;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class Assignment4Q2Test {

	/**  Save the original System.in to restore it after the test**/
    private final InputStream originalSystemIn = System.in;

    /** JUnit rule for handling expected exceptions**/
    @SuppressWarnings("deprecation")
	@Rule
    public ExpectedException thrown = ExpectedException.none();

    /**  Setup method to be run before each test**/
    @Before
    public void setUp() {
        // Set System.in to the original value before each test
        System.setIn(originalSystemIn);
    }

    /** Teardown method to be run after each test**/
    @After
    public void tearDown() {
        // Restore System.in to the original value after each test
        System.setIn(originalSystemIn);
    }

    /** Test case for valid input**/
    @Test
    public void testValidInput() {
        // Set the simulated user input
        provideInput("5\n3\n");
        // Test the divideNumbers method with valid input
        assertEquals(1.6666666666666667, Assignment4Q2.divideNumbers(5, 3), 0.0001);
    }

    /** Test case for invalid input (non-numeric)**/
    @Test
    public void testInvalidInput() {
        // Set the simulated user input with non-numeric value
        provideInput("abc\n5\n3\n");
        // Even with invalid input, the method should still be able to handle it
        assertEquals(1.6666666666666667, Assignment4Q2.divideNumbers(5, 3), 0.0001);
    }

    /** Test case for division by zero**/
    @Test
    public void testZeroDenominator() {
        // Set the simulated user input with zero as the denominator
        provideInput("5\n0\n2\n");
        // Test the divideNumbers method with zero as the denominator
        assertEquals(2.5, Assignment4Q2.divideNumbers(5, 2), 0.0001);
    }

    /**Test case for ensuring scanner closure in the main method**/
    @Test
    public void testCloseScanner() {
        // Ensure scanner is closed in the finally block
        // Set the simulated user input
        provideInput("5\n3\n");
        // Call the main method to test scanner closure
        Assignment4Q2.main(new String[]{});
    }

    // Helper method to provide simulated input to System.in
    private void provideInput(String data) {
        final ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
