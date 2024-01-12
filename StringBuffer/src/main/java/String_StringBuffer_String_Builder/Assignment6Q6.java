package String_StringBuffer_String_Builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment6Q6 {

    private static final Logger logger = Logger.getLogger(Assignment6Q6.class.getName());

    public static String reverseString(String originalString) {
        // Create a StringBuffer from the original string
        StringBuffer stringBuffer = new StringBuffer(originalString);

        // Use the reverse() method to reverse the string
        stringBuffer.reverse();

        // Return the reversed string
        return stringBuffer.toString();
    }
    

    @Test
    void testReverseString_EmptyString() {
        // Given an empty string
        String originalString = "";

        // Call the method
        String result = Assignment6Q6.reverseString(originalString);

        // Check if the result is an empty string (no change)
        assertEquals("", result);
    }

    public static void main(String[] args) {
        // Given string
        String originalString = "This method returns the reversed object on which it was called";

        // Call the method and log the reversed string using logger
        logger.info("Reversed String: " + reverseString(originalString));
    }
}
