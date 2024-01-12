package String_StringBuffer_StringBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import String_StringBuffer_String_Builder.Assignment6Q2;

class Assignment6Q2Test {

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
}
