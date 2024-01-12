package exceptionhandling;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Assignment4Q1 {

    private final InputStream originalSystemIn = System.in;

    private static final Logger logger = Logger.getLogger(Assignment4Q1.class.getName());

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

    @Test
    public void testValidInput() {
        provideInput("5\n3\n");
        assertEquals(1.6666666666666667, Assignment4Q1.divideNumbers(5, 3), 0.0001);
    }

    @Test
    public void testInvalidInput() {
        provideInput("abc\n5\n3\n");
        assertEquals(1.6666666666666667, Assignment4Q1.divideNumbers(5, 3), 0.0001);
    }

    @Test
    public void testZeroDenominator() {
        provideInput("5\n0\n2\n");
        assertEquals(2.5, Assignment4Q1.divideNumbers(5, 2), 0.0001);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        processInput(scanner);
        scanner.close();
    }

    public static void processInput(final Scanner scanner) {
        try {
            final double numerator = getValidNumber("Enter the first number: ", scanner);
            final double denominator = getValidNonZeroNumber("Enter the second number: ", scanner);

            final double result = divideNumbers(numerator, denominator);
            logger.log(Level.INFO, "Result of division: " + result);
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }
    }

    public static double divideNumbers(final double numerator, final double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }

    public static double getValidNumber(final String message, final Scanner scanner) {
        while (true) {
            try {
                logger.log(Level.INFO, message);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                logger.log(Level.SEVERE, "Error: Invalid input. Please enter a valid numeric value.");
            } catch (NoSuchElementException e) {
                scanner.nextLine();
                logger.log(Level.SEVERE, "Error: Missing input. Please enter a valid numeric value.");
            }
        }
    }

    public static double getValidNonZeroNumber(final String message, final Scanner scanner) {
        while (true) {
            final double number = getValidNumber(message, scanner);
            if (number != 0) {
                return number;
            } else {
                logger.log(Level.SEVERE, "Error: Cannot divide by zero. Please enter a non-zero denominator.");
            }
        }
    }
}
