package Java11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment8Q3 {

    private static final Logger logger = Logger.getLogger(Assignment8Q3.class.getName());

    

    @Test
    void testArrayListToArrayConversion() {
        // Given sentence
        String sentence = "A quick brown fox jumps over the lazy dog";

        // Create an ArrayList from the given sentence
        List<String> wordList = Arrays.asList(sentence.split(" "));
        ArrayList<String> wordArrayList = new ArrayList<>(wordList);

        // Convert the ArrayList to an array using Java 11 methods
        String[] wordArray = wordArrayList.toArray(new String[0]);

        // Expected result
        String[] expectedArray = { "A", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" };

        // Verify that the arrays are equal
        assertArrayEquals(expectedArray, wordArray, "Arrays should be equal");
    }
    
    @Test
    void testEmptyArrayListToArrayConversion() {
        // Given an empty ArrayList
        ArrayList<String> emptyList = new ArrayList<>();

        // Convert the empty ArrayList to an array using Java 11 methods
        String[] emptyArray = emptyList.toArray(new String[0]);

        // Expected result: An empty array
        String[] expectedArray = {};
        
        // Verify that the arrays are equal
        assertArrayEquals(expectedArray, emptyArray, "Arrays should be equal for an empty ArrayList");
    }

    @Test
    void testArrayListWithNullsToArrayConversion() {
        // Given an ArrayList with null elements
        ArrayList<String> listWithNulls = new ArrayList<>(Arrays.asList("A", null, "B", null, "C"));

        // Convert the ArrayList to an array using Java 11 methods
        String[] arrayWithNulls = listWithNulls.toArray(new String[0]);

        // Expected result: An array with null elements
        String[] expectedArray = { "A", null, "B", null, "C" };

        // Verify that the arrays are equal
        assertArrayEquals(expectedArray, arrayWithNulls, "Arrays should be equal for an ArrayList with nulls");
    }

    @Test
    void testArrayListToArrayConversionWithResize() {
        // Given an ArrayList with more elements than the initial array size
        ArrayList<String> longList = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        // Convert the ArrayList to an array using Java 11 methods
        String[] resizedArray = longList.toArray(new String[3]);

        // Expected result: The array should be resized to accommodate all elements
        String[] expectedArray = { "A", "B", "C", "D", "E", "F", "G" };

        // Verify that the arrays are equal
        assertArrayEquals(expectedArray, resizedArray, "Arrays should be equal with resized array");
    }
    public static void main(String[] args) {
        try {
            // Given sentence
            String sentence = "A quick brown fox jumps over the lazy dog";

            // Create an ArrayList from the given sentence
            List<String> wordList = Arrays.asList(sentence.split(" "));
            ArrayList<String> wordArrayList = new ArrayList<>(wordList);

            // Convert the ArrayList to an array using Java 11 methods
            String[] wordArray = wordArrayList.toArray(new String[0]);

            // Logging example
            logger.log(Level.INFO, "Converted ArrayList to array: " + Arrays.toString(wordArray));

            // Print the array elements
            logger.info("Array elements: " + Arrays.toString(wordArray));
        } catch (Exception e) {
            // Handle exceptions and log errors
            logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
        }
    }
}
