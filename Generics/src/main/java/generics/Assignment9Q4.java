package generics;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Generic class representing a Pair with key and value of any type.
 */
class Pair<K, V> {
    private static final Logger logger = Logger.getLogger(Pair.class.getName());

    private K key;
    private V value;

    /**
     * Constructor to create a Pair with specified key and value.
     *
     * @param key   The key of the pair.
     * @param value The value of the pair.
     */
    public Pair(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Setter method for setting the key, with type checking.
     *
     * @param key The key to set.
     */
    public void setKey(final K key) {
        if (key instanceof String) {
            this.key = key;
        } else {
            logger.log(Level.WARNING, "Invalid data type for key. Only String is allowed.");
        }
    }

    /**
     * Setter method for setting the value, with type checking.
     *
     * @param value The value to set.
     */
    public void setValue(final V value) {
        if (value instanceof String || value instanceof Date) {
            this.value = value;
        } else {
            logger.log(Level.WARNING, "Invalid data type for value. Only String or Date is allowed.");
        }
    }

    /**
     * Getter method for retrieving the key.
     *
     * @return The key of the pair.
     */
    public K getKey() {
        return key;
    }

    /**
     * Getter method for retrieving the value.
     *
     * @return The value of the pair.
     */
    public V getValue() {
        return value;
    }
}

/**
 * Class for demonstrating the usage of the Pair class.
 */
public class Assignment9Q4 {

    private static final Logger logger = Logger.getLogger(Assignment9Q4.class.getName());

    /**
     * JUnit test case for testing the Pair class with different scenarios.
     */
    @Test
    void testPair() {
        // Scenario a: String key and String value
        Pair<String, String> pair1 = new Pair<>("1", "Hello");

        // Verify that the key and value are set correctly
        assertEquals("1", pair1.getKey(), "Scenario a - Key should be '1'");
        assertEquals("Hello", pair1.getValue(), "Scenario a - Value should be 'Hello'");

        // Scenario b: String key and java.util.Date value
        Pair<String, Date> pair2 = new Pair<>("Today is", new Date());

        // Verify that the key and value are set correctly
        assertEquals("Today is", pair2.getKey(), "Scenario b - Key should be 'Today is'");
        assertEquals(new Date(), pair2.getValue(), "Scenario b - Value should be the current date");

        // Logging the scenarios
        logger.log(Level.INFO, "Scenario a: " + pair1.getKey() + " - " + pair1.getValue());
        logger.log(Level.INFO, "Scenario b: " + pair2.getKey() + " - " + pair2.getValue());
    }

    /**
     * Main method for demonstrating key-value pairs.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Scenario a: String key and String value
        final Pair<String, String> pair1 = new Pair<>("1", "Hello");

        // Logging Scenario a
        logger.log(Level.INFO, "Scenario a: " + pair1.getKey() + " - " + pair1.getValue());

        // Scenario b: String key and java.util.Date value
        final Pair<String, Date> pair2 = new Pair<>("Today is", new Date());

        // Logging Scenario b
        logger.log(Level.INFO, "Scenario b: " + pair2.getKey() + " - " + pair2.getValue());
    }
}
