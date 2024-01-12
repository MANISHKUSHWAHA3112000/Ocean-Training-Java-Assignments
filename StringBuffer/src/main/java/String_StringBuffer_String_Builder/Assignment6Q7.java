package String_StringBuffer_String_Builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment6Q7 {

    private static final Logger logger = Logger.getLogger(Assignment6Q7.class.getName());

    public static String manipulateStrings() {
        // Assignment 1: Append strings using StringBuilder
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Java StringBuilder is a powerful class");
        stringBuilder1.append(" for string manipulation.");

        // Assignment 2: Reverse a string using StringBuilder
        String originalString = "Reverse this string using StringBuilder";
        StringBuilder stringBuilder2 = new StringBuilder(originalString);
        stringBuilder2.reverse();

        // Assignment 3: Insert text at a specific index using StringBuilder
        StringBuilder stringBuilder3 = new StringBuilder("Insert at index _ in this string.");
        int index = stringBuilder3.indexOf("_");

        if (index != -1) {
            stringBuilder3.insert(index, "text ");
        }

        // Return the combined result
        return "Assignment 1: " + stringBuilder1.toString() + "\n"
                + "Assignment 2: Reversed String - " + stringBuilder2.toString() + "\n"
                + "Assignment 3: " + stringBuilder3.toString();
    }

    @Test
    void testManipulateStrings() {
        // Call the method to get the result
        String result = Assignment6Q7.manipulateStrings();

        // Define the expected output
        String expectedOutput = "Assignment 1: Java StringBuilder is a powerful class for string manipulation.\n"
                + "Assignment 2: Reversed String - redliuBgnirtS gnisu gnirts siht esreveR\n"
                + "Assignment 3: Insert at index text _ in this string.";

        // Check if the result matches the expected output
        assertEquals(expectedOutput, result);
    }
    
    public static void main(String[] args) {
        // Log the result using logger
        logger.info(manipulateStrings());
    }
}
