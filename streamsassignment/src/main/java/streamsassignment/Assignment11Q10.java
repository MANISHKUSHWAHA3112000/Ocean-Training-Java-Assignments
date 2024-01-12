package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;


public class Assignment11Q10 {

    private static final Logger logger = Logger.getLogger(Assignment11Q10.class.getName());
    

    @Test
    void testFindAndSortTradersFromCity() {
        // Create test traders
        Trader trader1 = new Trader("Manish", "Pune");
        Trader trader2 = new Trader("Gourav", "Mumbai");
        Trader trader3 = new Trader("Aryan", "Pune");
        Trader trader4 = new Trader("Krishna", "Pune");

        List<Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Find and sort traders from Pune
        List<Trader> result = Assignment11Q10.findAndSortTradersFromCity(traders, "Pune");

        // Expected result after sorting: Bob, Eve, John
        assertEquals(3, result.size());
        assertEquals(trader3, result.get(0));
        assertEquals(trader4, result.get(1));
        assertEquals(trader1, result.get(2));
    }

    public static List<Trader> findAndSortTradersFromCity(List<Trader> traders, String city) {
        return traders.stream()
                .filter(trader -> trader.city.equals(city))
                .sorted(Comparator.comparing(trader -> trader.name))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Trader trader1 = new Trader("Manish", "Pune");
        Trader trader2 = new Trader("Gourav", "Mumbai");
        Trader trader3 = new Trader("Aryan", "Pune");
        Trader trader4 = new Trader("Krishna", "Pune");

        List<Trader> traders = List.of(trader1, trader2, trader3, trader4);

        List<Trader> result = findAndSortTradersFromCity(traders, "Pune");

        // Logging the result
        logger.info("Traders from Pune, sorted by name:");
        result.forEach(trader -> logger.info("Name: " + trader.name + ", City: " + trader.city));
    }

    static class Trader {
        String name;
        String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }
    }
}
