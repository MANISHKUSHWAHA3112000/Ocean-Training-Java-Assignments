package Java11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

@FunctionalInterface
interface SimpleInterestCalculator {
    double calculate(double principal, double rate, double time);
}

public class Assignment8Q1 {
	

    private static final Logger logger = Logger.getLogger(Assignment8Q1.class.getName());

    
    @Test
    void testSimpleInterestCalculator() {
        // Given
        double principal = 1000.0;
        double rate = 5.0;
        double time = 2.0;

        // When
        SimpleInterestCalculator calculator = (p, r, t) -> (p * r * t) / 100;
        double calculatedSimpleInterest = calculator.calculate(principal, rate, time);

        // Then
        double expectedSimpleInterest = 100.0; // The expected result for principal=1000, rate=5, time=2
        assertEquals(expectedSimpleInterest, calculatedSimpleInterest, 0.01); // Tolerance of 0.01 for double comparison
    }
    
    @Test
    void testSimpleInterestCalculatorWithZeroPrincipal() {
        // Given
        double principal = 0.0;
        double rate = 5.0;
        double time = 2.0;

        // When
        SimpleInterestCalculator calculator = (p, r, t) -> (p * r * t) / 100;
        double calculatedSimpleInterest = calculator.calculate(principal, rate, time);

        // Then
        double expectedSimpleInterest = 0.0; // The expected result for principal=0, rate=5, time=2
        assertEquals(expectedSimpleInterest, calculatedSimpleInterest, 0.01);
    }

    @Test
    void testSimpleInterestCalculatorWithZeroRate() {
        // Given
        double principal = 1000.0;
        double rate = 0.0;
        double time = 2.0;

        // When
        SimpleInterestCalculator calculator = (p, r, t) -> (p * r * t) / 100;
        double calculatedSimpleInterest = calculator.calculate(principal, rate, time);

        // Then
        double expectedSimpleInterest = 0.0; // The expected result for principal=1000, rate=0, time=2
        assertEquals(expectedSimpleInterest, calculatedSimpleInterest, 0.01);
    }

    @Test
    void testSimpleInterestCalculatorWithZeroTime() {
        // Given
        double principal = 1000.0;
        double rate = 5.0;
        double time = 0.0;

        // When
        SimpleInterestCalculator calculator = (p, r, t) -> (p * r * t) / 100;
        double calculatedSimpleInterest = calculator.calculate(principal, rate, time);

        // Then
        double expectedSimpleInterest = 0.0; // The expected result for principal=1000, rate=5, time=0
        assertEquals(expectedSimpleInterest, calculatedSimpleInterest, 0.01);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read principal amount
            logger.log(Level.INFO, "Enter principal amount: ");
            double principal = scanner.nextDouble();

            // Read rate of interest
            logger.log(Level.INFO, "Enter rate of interest: ");
            double rate = scanner.nextDouble();

            // Read time period
            logger.log(Level.INFO, "Enter time period in years: ");
            double time = scanner.nextDouble();

            // Using a functional interface and lambda expression to calculate simple interest
            SimpleInterestCalculator calculator = (p, r, t) -> (p * r * t) / 100;

            // Calculate simple interest using the lambda expression
            double simpleInterest = calculator.calculate(principal, rate, time);

            // Display the result using logger
            logger.log(Level.INFO, "Simple Interest: " + simpleInterest);
        } catch (Exception e) {
            // Log any exception using logger
            logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
        } finally {
            // Close the scanner to avoid resource leak
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
