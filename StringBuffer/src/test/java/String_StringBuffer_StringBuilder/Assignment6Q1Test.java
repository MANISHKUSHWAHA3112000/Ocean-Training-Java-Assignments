package String_StringBuffer_StringBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import String_StringBuffer_String_Builder.Assignment6Q1;

class Assignment6Q1Test {

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
}
