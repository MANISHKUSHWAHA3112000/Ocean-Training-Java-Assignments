package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Assignment11Q9 {
	
	private static final Logger logger = Logger.getLogger(Assignment11Q9.class.getName());

    public static Set<String> uniqueCities(List<Trader> traders) {
        return traders.stream()
                .map(trader -> trader.city)
                .collect(Collectors.toSet());
    }
    
    @Test
    void testUniqueCities() {
        // Create test traders
        Trader trader1 = new Trader("Manish", "New York");
        Trader trader2 = new Trader("Gourav", "London");
        Trader trader3 = new Trader("Aryan", "Paris");
        Trader trader4 = new Trader("Kamlesh", "New York");

        List<Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Find unique cities
        Set<String> uniqueCities = Assignment11Q9.uniqueCities(traders);

        // Expected result: New York, London, Paris
        assertEquals(3, uniqueCities.size());
        assertEquals(Set.of("New York", "London", "Paris"), uniqueCities);
    }

    public static void main(String[] args) {
        // Create test traders
        Trader trader1 = new Trader("Manish", "New York");
        Trader trader2 = new Trader("Gourav", "London");
        Trader trader3 = new Trader("Aryan", "Paris");
        Trader trader4 = new Trader("Krishna", "New York");

        List<Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Find unique cities
        Set<String> uniqueCities = uniqueCities(traders);

        // Display the result
        logger.info("Unique Cities: " + uniqueCities);
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
