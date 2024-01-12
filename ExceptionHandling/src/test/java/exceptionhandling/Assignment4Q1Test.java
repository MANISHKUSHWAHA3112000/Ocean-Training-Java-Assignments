package exceptionhandling ;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



/**
 * This class contains JUnit test cases for Assignment4Q1.
 */
public class Assignment4Q1Test {

    private final InputStream originalSystemIn = System.in;

    @SuppressWarnings("deprecation")
	@Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        System.setIn(originalSystemIn);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    /**
     * Test case for valid input.
     */
    @Test
    public void testValidInput() {
        provideInput("5\n3\n");
        assertEquals(1.666_666_666_666_666_7, Assignment4Q1.divideNumbers(5, 3), 0.0001);
    }

    /**
     * Test case for invalid input.
     */
    @Test
    public void testInvalidInput() {
        provideInput("abc\n5\n3\n");
        assertEquals(1.666_666_666_666_666_7, Assignment4Q1.divideNumbers(5, 3), 0.0001);
    }

    /**
     * Test case for zero denominator.
     */
    @Test
    public void testZeroDenominator() {
        provideInput("5\n0\n2\n");
        assertEquals(2.5, Assignment4Q1.divideNumbers(5, 2), 0.0001);
    }

    private void provideInput(String data) {
        try (ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes())) {
            System.setIn(testIn);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }
}
