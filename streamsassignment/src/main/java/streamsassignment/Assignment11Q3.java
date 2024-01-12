package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Assignment11Q3 {

    private static final Logger logger = Logger.getLogger(Assignment11Q3.class.getName());
    
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

    public static void main(String[] args) {
        // Create a list of fruits
        List<Fruit> fruits = Arrays.asList(
                new Fruit("Apple", 95, 2, "Red"),
                new Fruit("Cherry", 80, 5, "Red"),
                new Fruit("Strawberry", 45, 3, "Red"),
                new Fruit("Grapes", 68, 4, "Purple"),
                new Fruit("Watermelon", 30, 6, "Green")
        );

        // Display only RED color fruits sorted by price in ascending order
        List<Fruit> redFruitsSortedByPrice = displayRedFruitsSortedByPrice(fruits);
        redFruitsSortedByPrice.forEach(fruit -> {
            logger.info(fruit.getName() + " - Price: RS " + fruit.getPrice());
        });
    }

    static List<Fruit> displayRedFruitsSortedByPrice(List<Fruit> fruits) {
        if (fruits == null) {
            return Collections.emptyList(); // Return an empty list if input is null
        }

        return fruits.stream()
                .filter(fruit -> "Red".equals(fruit.getColor()))
                .sorted(Comparator.comparingInt(Fruit::getPrice))
                .collect(Collectors.toList());
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

        public int getPrice() {
            return price;
        }

        public String getColor() {
            return color;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Fruit fruit = (Fruit) obj;
            return calories == fruit.calories &&
                    price == fruit.price &&
                    name.equals(fruit.name) &&
                    color.equals(fruit.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, calories, price, color);
        }
    }
}
