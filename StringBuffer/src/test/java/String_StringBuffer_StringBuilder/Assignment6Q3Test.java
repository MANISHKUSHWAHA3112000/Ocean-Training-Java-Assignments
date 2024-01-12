package String_StringBuffer_StringBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import String_StringBuffer_String_Builder.Assignment6Q3;

class Assignment6Q3Test {

    @Test
    void testToLowercase() {
        Assignment6Q3 assignment = new Assignment6Q3();
        String result = assignment.toLowercase("HelloWorld");
        assertEquals("helloworld", result);
    }

    @Test
    void testToUppercase() {
        Assignment6Q3 assignment = new Assignment6Q3();
        String result = assignment.toUppercase("HelloWorld");
        assertEquals("HELLOWORLD", result);
    }

    @Test
    void testReplaceCharacter() {
        Assignment6Q3 assignment = new Assignment6Q3();
        String result = assignment.replaceCharacter("HelloWorld", 'o', 'X');
        assertEquals("HellXWXrld", result);
    }

    @Test
    void testContainsWord() {
        Assignment6Q3 assignment = new Assignment6Q3();
        assertTrue(assignment.containsWord("HelloWorld", "World"));
        assertFalse(assignment.containsWord("HelloWorld", "Java"));
    }

    @Test
    void testStringsMatch() {
        Assignment6Q3 assignment = new Assignment6Q3();
        assertTrue(assignment.stringsMatch("Hello", "Hello"));
        assertFalse(assignment.stringsMatch("Hello", "hello"));
    }

    @Test
    void testStringsEqual() {
        Assignment6Q3 assignment = new Assignment6Q3();
        assertTrue(assignment.stringsEqual("Hello", "Hello"));
        assertFalse(assignment.stringsEqual("Hello", "hello"));
    }
}
