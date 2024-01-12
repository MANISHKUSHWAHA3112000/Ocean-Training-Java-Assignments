package generics;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for Assignment9Q2.
 */
class Assignment9Q2Test {

    /** Junit test case for generate Random **/
    @Test
    void testGenerateRandomMap() {
        // Create an instance of RandomMapGenerator to test
        @SuppressWarnings("unused")
		Assignment9Q2 mapGenerator = new Assignment9Q2();

        // Generate the random map using the method to be tested
        Map<Integer, Double> randomMap = Assignment9Q2.generateRandomMap(10);

        // Verify the size of the generated map
        assertEquals(10, randomMap.size(), "Generated map size should be 10");

        // Verify the data types of keys and values in the map
        for (Map.Entry<Integer, Double> entry : randomMap.entrySet()) {
            assertKeyType(entry.getKey());
            assertValueType(entry.getValue());
        }

        // Add more specific test cases based on your requirements

        // Test case: Ensure the generated keys are within the expected range
        for (Map.Entry<Integer, Double> entry : randomMap.entrySet()) {
            assertTrue(entry.getKey() >= Integer.MIN_VALUE && entry.getKey() <= Integer.MAX_VALUE,
                    "Generated key should be within the expected range");
        }

        // Test case: Ensure the generated values are within the expected range
        for (Map.Entry<Integer, Double> entry : randomMap.entrySet()) {
            assertTrue(entry.getValue() >= 0.0 && entry.getValue() < 1.0,
                    "Generated value should be within the expected range");
        }

        // Test case: Ensure the generated map is not null
        assertTrue(randomMap != null, "Generated map should not be null");
    }

    private void assertKeyType(Integer key) {
        assertTrue(key instanceof Integer, "Key should be of type Integer");
    }

    private void assertValueType(Double value) {
        assertTrue(value instanceof Double, "Value should be of type Double");
    }
}
