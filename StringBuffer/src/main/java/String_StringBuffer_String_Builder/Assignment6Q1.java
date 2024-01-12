package String_StringBuffer_String_Builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment6Q1 {

    private static final Logger logger = Logger.getLogger(Assignment6Q1.class.getName());
    

    @Test
    void testStringLengthWithRegularString() {
        // Given
        String str = "Hello World";

        // When
        int length = Assignment6Q1.calculateStringLength(str);

        // Then
        assertEquals(11, length, "The length of the string should be 11");
    }

    @Test
    void testStringLengthWithEmptyString() {
        // Given
        String str = "";

        // When
        int length = Assignment6Q1.calculateStringLength(str);

        // Then
        assertEquals(0, length, "The length of an empty string should be 0");
    }

    @Test
    void testStringLengthWithSpaces() {
        // Given
        String str = "   ";

        // When
        int length = Assignment6Q1.calculateStringLength(str);

        // Then
        assertEquals(3, length, "The length of a string with spaces should be the number of spaces");
    }

    @Test
    void testStringLengthWithSpecialCharacters() {
        // Given
        String str = "!@#$%^&*()";

        // When
        int length = Assignment6Q1.calculateStringLength(str);

        // Then
        assertEquals(10, length, "The length of a string with special characters should be the number of characters");
    }

    public static int calculateStringLength(String str) {
        return str.length();
    }

    public static void main(String[] args) {
        // Define the string
        String str = "Hello World";

        // Determine the length of the string using the length() method
        int length = calculateStringLength(str);

        // Print the result using logger
        logger.info("The length of the string \"" + str + "\" is: " + length);
    }
}
