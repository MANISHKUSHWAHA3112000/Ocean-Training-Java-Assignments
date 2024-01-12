package String_StringBuffer_StringBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import String_StringBuffer_String_Builder.Assignment6Q7;

class Assignment6Q7Test {

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
}
