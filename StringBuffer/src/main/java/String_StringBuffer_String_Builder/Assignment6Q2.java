package String_StringBuffer_String_Builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment6Q2 {

    private static final Logger logger = Logger.getLogger(Assignment6Q2.class.getName());
    

    @Test
    void testConcatenation() {
        // Given
        String str1 = "Hello, ";
        String str2 = "How are you?";

        // When
        String result = Assignment6Q2.concatenateStrings(str1, str2);

        // Then
        assertEquals("Hello, How are you?", result, "Concatenation should be 'Hello, How are you?'");
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1.concat(str2);
    }

    public static void main(String[] args) {
        // Define the strings
        String str1 = "Hello, ";
        String str2 = "How are you?";

        // Join the strings using the concat() method
        String result = concatenateStrings(str1, str2);

        // Print the result using logger
        logger.info(result);
    }
}
