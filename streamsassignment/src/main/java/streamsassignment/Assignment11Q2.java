package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;



public class Assignment11Q2 {

    private static final Logger logger = Logger.getLogger(Assignment11Q2.class.getName());

    static public Map<String, List<String>> groupFruitsByColor(List<Fruit> fruits) {
        return fruits.stream()
                .collect(Collectors.groupingBy(
                        Fruit::getColor,
                        Collectors.mapping(Fruit::getName, Collectors.toList())
                ));
    }
    
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

    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("Apple", 95, 2, "Red"),
                new Fruit("Banana", 105, 1, "Yellow"),
                new Fruit("Orange", 80, 3, "Orange"),
                new Fruit("Grapes", 68, 4, "Purple"),
                new Fruit("Kiwi", 61, 5, "Brown"),
                new Fruit("Strawberry", 45, 6, "Red")
        );

        Map<String, List<String>> colorWiseFruits = groupFruitsByColor(fruits);
        colorWiseFruits.forEach((color, fruitNames) -> {
            logger.info("Fruits with color " + color + ": " + fruitNames);
        });
    }

    static class Fruit {
        String name;
        int calories;
        int price;
        String color;

        public Fruit(String name, int calories, int price, String color) {
            this.name = name;
            this.calories = calories;
            this.price = price;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public int getCalories() {
            return calories;
        }

        public int getPrice() {
            return price;
        }

        public String getColor() {
            return color;
        }
    }
}
