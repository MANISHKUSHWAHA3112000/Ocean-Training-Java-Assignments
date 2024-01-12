package String_StringBuffer_StringBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import String_StringBuffer_String_Builder.Assignment6Q6;

class Assignment6Q6Test {


    @Test
    void testReverseString_EmptyString() {
        // Given an empty string
        String originalString = "";

        // Call the method
        String result = Assignment6Q6.reverseString(originalString);

        // Check if the result is an empty string (no change)
        assertEquals("", result);
    }
}
