package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Assignment11Q1Test {

	@Test
    void testGetLowCalorieFruitNames() {
        // Create a list of fruits for testing
        List<Fruit> fruits = Arrays.asList(
                new Fruit("Apple", 95, 2, "Red"),
                new Fruit("Banana", 105, 1, "Yellow"),
                new Fruit("Orange", 80, 3, "Orange"),
                new Fruit("Grapes", 68, 4, "Purple")
        );

        // Get the low-calorie fruit names
        List<String> result = Assignment11Q1.getLowCalorieFruitNames(fruits);

        // Expected result: ["Grapes", "Orange", "Apple"]
        List<String> expected = Arrays.asList("Grapes", "Orange", "Apple");

        // Assert that the result matches the expected list
        assertEquals(expected, result);
    }

}
