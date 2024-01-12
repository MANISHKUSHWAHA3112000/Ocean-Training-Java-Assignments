package streamsassignment;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import streamsassignment.Assignment11Q2.Fruit;

class Assignment11Q2Test {

    @Test
    
    void testGroupFruitsByColor() {
        // Create a list of fruits for testing
        List<Fruit> fruits = Arrays.asList(
                new Fruit("Apple", 95, 2, "Red"),
                new Fruit("Banana", 105, 1, "Yellow"),
                new Fruit("Orange", 80, 3, "Orange"),
                new Fruit("Grapes", 68, 4, "Purple"),
                new Fruit("Kiwi", 61, 5, "Brown"),
                new Fruit("Strawberry", 45, 6, "Red")
        );

        // Expected result based on the provided fruits
        Map<String, List<String>> expected = Map.of(
                "Red", Arrays.asList("Apple", "Strawberry"),
                "Yellow", Arrays.asList("Banana"),
                "Orange", Arrays.asList("Orange"),
                "Purple", Arrays.asList("Grapes"),
                "Brown", Arrays.asList("Kiwi")
        );

        // Call the method to be tested
        Map<String, List<String>> result = Assignment11Q2.groupFruitsByColor(fruits);

        // Assert that the result matches the expected map
        assertEquals(expected, result);
    }
}
