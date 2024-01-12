package Java11;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Assignment8Q1Test {

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

    

}

