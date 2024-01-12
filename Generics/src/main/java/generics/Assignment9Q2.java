package generics;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Utility class for generating a random map with integer keys and double values.
 */
public final class Assignment9Q2 {

    private static final Logger logger = Logger.getLogger(Assignment9Q2.class.getName());

    /** private constructor **/
    Assignment9Q2() {
    }

    /** JUnit test case for generate Random **/
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

        // Display details of the generated map
        displayMapDetails(randomMap);
    }

    private void assertKeyType(Integer key) {
        assertTrue(key instanceof Integer, "Key should be of type Integer");
    }

    private void assertValueType(Double value) {
        assertTrue(value instanceof Double, "Value should be of type Double");
    }

    /**
     * Displays the details of the generated map using the provided Logger.
     *
     * @param randomMap The generated map to display.
     */
    private static void displayMapDetails(Map<Integer, Double> randomMap) {
        for (Map.Entry<Integer, Double> entry : randomMap.entrySet()) {
            // Redirect the output to the console (you might want to adapt this part based on your needs)
            logger.log(Level.INFO, "Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    /**
     * Generates a random map with the specified number of entries.
     *
     * @param numberOfEntries The number of entries to generate in the map.
     * @return The generated map with random integer keys and double values.
     */
    public static Map<Integer, Double> generateRandomMap(final int numberOfEntries) {
        // Create a ConcurrentHashMap to hold random int keys and random double values
        final Map<Integer, Double> randomMap = new ConcurrentHashMap<>();

        // Generate and store random int keys and random double values
        for (int i = 0; i < numberOfEntries; i++) {
            final int randomKey = generateRandomInt();
            final double randomValue = generateRandomDouble();
            randomMap.put(randomKey, randomValue);
        }

        return randomMap;
    }

    /**
     * Generates a random integer.
     *
     * @return The generated random integer.
     */
    private static int generateRandomInt() {
        final Random random = new Random();
        return random.nextInt();
    }

    /**
     * Generates a random double.
     *
     * @return The generated random double.
     */
    private static double generateRandomDouble() {
        final Random random = new Random();
        return random.nextDouble();
    }

    /**
     * The main method of the program responsible for user input, division calculation,
     * and displaying the result or an error message.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        // Call the generateRandomMap method with 10 entries and print the result
        final Map<Integer, Double> randomMap = generateRandomMap(10);
        displayMapDetails(randomMap);
    }
}
