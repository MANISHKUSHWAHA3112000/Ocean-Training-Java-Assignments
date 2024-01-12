package String_StringBuffer_StringBuilder;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import String_StringBuffer_String_Builder.Assignment6Q4;

class Assignment6Q4Test {

    @Test
    void testBuildString() {
        // Create an instance of Assignment6Q4
        Assignment6Q4 assignment = new Assignment6Q4();

        // Expected result based on the concatenation in buildString
        String expected = "StringBuffer is a peer class of String that provides much of the functionality of strings";

        // Invoke the buildString method
        String result = assignment.buildString();

        // Assert that the result matches the expected value
        assertEquals(expected, result);
    }
}
