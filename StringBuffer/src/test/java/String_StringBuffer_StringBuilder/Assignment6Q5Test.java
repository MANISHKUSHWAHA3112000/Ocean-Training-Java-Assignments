package String_StringBuffer_StringBuilder;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import String_StringBuffer_String_Builder.Assignment6Q5;

class Assignment6Q5Test {


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
}
