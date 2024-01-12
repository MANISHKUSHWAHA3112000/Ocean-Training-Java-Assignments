package streamsassignment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Assignment11Q3Test {

    @Test
    void testDisplayRedFruitsSortedByPrice() {
        List<Assignment11Q3.Fruit> fruits = List.of(
                new Assignment11Q3.Fruit("Apple", 95, 2, "Red"),
                new Assignment11Q3.Fruit("Cherry", 80, 5, "Red"),
                new Assignment11Q3.Fruit("Strawberry", 45, 3, "Red"),
                new Assignment11Q3.Fruit("Grapes", 68, 4, "Purple"),
                new Assignment11Q3.Fruit("Watermelon", 30, 6, "Green")
        );

        List<Assignment11Q3.Fruit> result = Assignment11Q3.displayRedFruitsSortedByPrice(fruits);

        assertEquals(3, result.size());
        assertEquals("Apple", result.get(0).getName());
        assertEquals("Strawberry", result.get(1).getName());
        assertEquals("Cherry", result.get(2).getName());
    }

    @Test
    void testDisplayRedFruitsSortedByPriceWithEmptyList() {
        List<Assignment11Q3.Fruit> fruits = List.of();

        List<Assignment11Q3.Fruit> result = Assignment11Q3.displayRedFruitsSortedByPrice(fruits);

        assertEquals(0, result.size());
    }

    @Test
    void testDisplayRedFruitsSortedByPriceWithNoRedFruits() {
        List<Assignment11Q3.Fruit> fruits = List.of(
                new Assignment11Q3.Fruit("Grapes", 68, 4, "Purple"),
                new Assignment11Q3.Fruit("Watermelon", 30, 6, "Green")
        );

        List<Assignment11Q3.Fruit> result = Assignment11Q3.displayRedFruitsSortedByPrice(fruits);

        assertEquals(0, result.size());
    }

    @Test
    void testDisplayRedFruitsSortedByPriceWithNullList() {
        List<Assignment11Q3.Fruit> fruits = null;

        List<Assignment11Q3.Fruit> result = Assignment11Q3.displayRedFruitsSortedByPrice(fruits);

        assertEquals(0, result.size());
    }
}
