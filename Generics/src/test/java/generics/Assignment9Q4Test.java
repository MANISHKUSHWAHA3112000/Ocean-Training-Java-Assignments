package generics;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Date;

import org.junit.jupiter.api.Test;

class Assignment9Q4Test {

    @Test
    void testPair() {
        // Scenario a: String key and String value
        Pair<String, String> pair1 = new Pair<>("1", "Hello");

        // Verify that the key and value are set correctly
        assertEquals("1", pair1.getKey(), "Scenario a - Key should be '1'");
        assertEquals("Hello", pair1.getValue(), "Scenario a - Value should be 'Hello'");

        // Scenario b: String key and java.util.Date value
        Pair<String, Date> pair2 = new Pair<>("Today is", new Date());

        // Verify that the key and value are set correctly
        assertEquals("Today is", pair2.getKey(), "Scenario b - Key should be 'Today is'");
        assertEquals(new Date(), pair2.getValue(), "Scenario b - Value should be the current date");

        
    }
}
