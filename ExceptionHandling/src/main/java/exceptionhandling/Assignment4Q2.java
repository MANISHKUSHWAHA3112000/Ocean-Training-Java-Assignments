package exceptionhandling;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Assignment4Q2 {

    private final InputStream originalSystemIn = System.in;
    private static final Logger logger = Logger.getLogger(Assignment4Q2.class.getName());

    @SuppressWarnings("deprecation")
	@Rule
    public ExpectedException thrown = ExpectedException.none();

    public Assignment4Q2() {
        // Additional setup logic can be added if needed
    }

    @Before
    public void setUp() {
        System.setIn(originalSystemIn);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testValidInput() {
        provideInput("5\n3\n");
        assertEquals(1.6666666666666667, Assignment4Q2.divideNumbers(5, 3), 0.0001);
    }

    @Test
    public void testInvalidInput() {
        provideInput("abc\n5\n3\n");
        assertEquals(1.6666666666666667, Assignment4Q2.divideNumbers(5, 3), 0.0001);
    }

    @Test
    public void testZeroDenominator() {
        provideInput("5\n0\n2\n");
        assertEquals(2.5, Assignment4Q2.divideNumbers(5, 2), 0.0001);
    }

    @Test
    public void testCloseScanner() {
        provideInput("5\n3\n");
        Assignment4Q2.main(new String[]{});
    }

    final void provideInput(String data) {
        final ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final double numerator = getValidNumber("Enter the first number: ", scanner);
        final double denominator = getValidNonZeroNumber("Enter the second number: ", scanner);

        try {
            final double result = divideNumbers(numerator, denominator);
            logger.log(Level.INFO, "Result of division: " + result);
        } catch (ArithmeticException e) {
            // Log error message
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
            logger.info("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double getValidNumber(String message, final Scanner scanner) {
        while (true) {
            try {
                logger.log(Level.INFO, message);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                logger.log(Level.WARNING, "Error: Invalid input. Please enter a valid numeric value.");
                logger.info("Error: Invalid input. Please enter a valid numeric value.");
            }
        }
    }

    private static double getValidNonZeroNumber(final String message, final Scanner scanner) {
        double number;
        while (true) {
            number = getValidNumber(message, scanner);
            if (number != 0) {
                break;
            } else {
                logger.log(Level.WARNING, "Error: Cannot divide by zero. Please enter a non-zero denominator.");
                logger.info("Error: Cannot divide by zero. Please enter a non-zero denominator.");
            }
        }
        return number;
    }

    static double divideNumbers(final double numerator, final double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }
}
