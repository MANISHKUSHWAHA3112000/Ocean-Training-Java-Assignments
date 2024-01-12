package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class Assignment11Q11 {

    private static final Logger logger = Logger.getLogger(Assignment11Q11.class.getName());

    public static String getAllTraderNamesSorted(List<Trader> traders) {
        return traders.stream()
                .map(trader -> trader.name)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    @Test
    void testGetAllTraderNamesSorted() {
        // Create test traders
        Trader trader1 = new Trader("Manish", "New York");
        Trader trader2 = new Trader("Gourav", "London");
        Trader trader3 = new Trader("Aryan", "Paris");
        Trader trader4 = new Trader("Kamlesh", "New York");

        List<Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Get all trader names sorted alphabetically
        String result = Assignment11Q11.getAllTraderNamesSorted(traders);

        // Split the result into an array for comparison
        String[] resultArray = result.split(", ");

        // Expected array of names sorted alphabetically
        String[] expectedArray = {"Aryan", "Gourav", "Kamlesh", "Manish"};

        // Use assertArrayEquals to compare arrays
        assertArrayEquals(expectedArray, resultArray);

        // Logging the result
        logger.info("Test Result - All Trader Names Sorted Alphabetically: " + result);
    }

    public static void main(String[] args) {
        // Create test traders
        Trader trader1 = new Trader("Manish", "New York");
        Trader trader2 = new Trader("Gourav", "London");
        Trader trader3 = new Trader("Aryan", "Paris");
        Trader trader4 = new Trader("Kamlesh", "New York");

        List<Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Get all trader names sorted alphabetically
        String result = getAllTraderNamesSorted(traders);

        // Logging the result
        logger.info("All Trader Names Sorted Alphabetically: " + result);
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
