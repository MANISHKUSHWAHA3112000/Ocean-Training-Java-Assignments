package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Fruit {
    private final String name;
    private final int calories;
    private final int price;
    private final String color;

    public Fruit(final String name, final int calories, final int price, final String color) {
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

public class Assignment11Q1 {

    private static final Logger logger = Logger.getLogger(Assignment11Q1.class.getName());

    public static List<String> getLowCalorieFruitNames(final List<Fruit> fruits) {
        return fruits.stream()
                .filter(fruit -> fruit.getCalories() < 100)
                .sorted(Comparator.comparingInt(Fruit::getCalories))
                .map(Fruit::getName)
                .collect(Collectors.toList());
    }
    

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

    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", 95, 2, "Red"));
        fruits.add(new Fruit("Banana", 105, 1, "Yellow"));
        fruits.add(new Fruit("Orange", 80, 3, "Orange"));
        fruits.add(new Fruit("Grapes", 68, 4, "Purple"));

        List<String> lowCalorieFruitNames = getLowCalorieFruitNames(fruits);

        // Logging the names of low-calorie fruits
        logger.info("Low-Calorie Fruits (calories < 100) in Ascending Order:");
        lowCalorieFruitNames.forEach(logger::info);
    }
}
