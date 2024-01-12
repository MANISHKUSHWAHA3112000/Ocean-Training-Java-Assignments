package String_StringBuffer_String_Builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment6Q5 {

    private static final Logger logger = Logger.getLogger(Assignment6Q5.class.getName());

    public static String insertTextAtPlaceholder(String originalString, String insertText) {
        // Find the index of the placeholder "_"
        int index = originalString.indexOf('_');

        // Check if the placeholder is found
        if (index != -1) {
            // Create a StringBuilder from the original string
            StringBuilder stringBuilder = new StringBuilder(originalString);

            // Insert the "insert text" at the specified index
            stringBuilder.insert(index, insertText);

            // Return the modified string
            return stringBuilder.toString();
        } else {
            return "Placeholder not found in the original string.";
        }
    }
    
    @Test
    void testInsertTextAtPlaceholder_PlaceholderNotFound() {
        // Given a string without a placeholder
        String originalString = "No placeholder here";
        String insertText = "insert text";

        // Call the method
        String result = Assignment6Q5.insertTextAtPlaceholder(originalString, insertText);

        // Check if the result indicates that the placeholder was not found
        assertEquals("Placeholder not found in the original string.", result);
    }

    public static void main(String[] args) {
        // Given strings
        String originalString = "It is used to _ at the specified index position";
        String insertText = "insert text";

        // Call the method and log the result using logger
        logger.info(insertTextAtPlaceholder(originalString, insertText));
    }
}
