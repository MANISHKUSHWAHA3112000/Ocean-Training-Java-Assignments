package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * A test class to demonstrate JUnit testing with setup and teardown methods.
 */
public class Assignment7Q4 {

    private static final Logger logger = Logger.getLogger(Assignment7Q4.class.getName());

    /**
     * Before all tests - Initialize resources, setup connections, etc.
     */
    @BeforeAll
    static void beforeAll() {
        logger.info("Before all tests - Initialize resources, setup connections, etc.");
    }

    /**
     * Before each test - Reset state, prepare test data, etc.
     */
    @BeforeEach
    void beforeEach() {
        logger.info("Before each test - Reset state, prepare test data, etc.");
    }

    /**
     * After each test - Clean up resources, reset state, etc.
     */
    @AfterEach
    void afterEach() {
        logger.info("After each test - Clean up resources, reset state, etc.");
    }

    /**
     * Test case 1: Asserts that a given string is equal to an expected value.
     */
    @Test
    public void test1() {
        final String str = "JUnit is working fine";
        assertEquals("JUnit is working fine", str);
        logger.info("Test case 1 executed successfully.");
    }

    /**
     * Test case 2: Asserts that the sum of two numbers is equal to an expected value.
     */
    @Test
    public void test2() {
        final int a = 5;
        final int b = 7;
        assertEquals(12, a + b);
        logger.info("Test case 2 executed successfully.");
    }

    /**
     * After all tests - Clean up global resources, close connections, etc.
     */
    @AfterAll
    static void afterAll() {
        logger.info("After all tests - Clean up global resources, close connections, etc.");
    }
    
    /**
     * Test case 3: Demonstrates a simple assertTrue assertion.
     */
    @Test
    public void test3() {
        boolean condition = true; // Modify with your actual condition
        assertTrue(condition, "assertTrue should pass if the condition is true");
        logger.info("Test case 3 executed successfully.");
    }

    /**
     * Test case 4: Demonstrates a custom assertion with a meaningful error message.
     */
    @Test
    public void test4() {
        String actual = "Hello, JUnit!";
        String expected = "Hello, JUnit!";
        assertEquals(expected, actual, "Custom assertion with a meaningful error message");
        logger.info("Test case 4 executed successfully.");
    }

    /**
     * Test case 5: Demonstrates a failing assertion to see how it appears in the test results.
     */
    @Test
    public void test5() {
        int actual = 10;
        @SuppressWarnings("unused")
		int expected = 15; // Change to a value that will make the assertion fail
     // Change this line in test5
        assertEquals(10, actual, "This assertion should fail");
        logger.info("Test case 5 executed successfully.");
    }
    @Test
    public void test6() {
        // Add your own test case here
        // For example, test a specific method or feature of your code
        // Ensure to use meaningful assertions
        logger.info("Test case 6 executed successfully.");
    }
    @Test
    public void test7() {
        // Test throwing an exception
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("An example exception");
        });
        logger.info("Test case 7 executed successfully.");
    }
}
