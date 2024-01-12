package streamsassignment;



import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Assignment11Q12 {

    private static final Logger logger = Logger.getLogger(Assignment11Q12.class.getName());

    public static boolean areTradersInCity(List<Trader> traders, String city) {
        return traders.stream()
                .anyMatch(trader -> trader.city.equals(city));
    }

    @Test
    void testAreTradersInCity() {
        // Create test traders
        Assignment11Q12.Trader trader1 = new Assignment11Q12.Trader("Manish", "New York");
        Assignment11Q12.Trader trader2 = new Assignment11Q12.Trader("Gourav", "London");
        Assignment11Q12.Trader trader3 = new Assignment11Q12.Trader("Sameer", "Paris");
        Assignment11Q12.Trader trader4 = new Assignment11Q12.Trader("Ankesh", "Indore");

        List<Assignment11Q12.Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Check if any traders are based in Indore
        boolean result = Assignment11Q12.areTradersInCity(traders, "Indore");

        // Display the result
        logger.info("Test Result - Are any traders based in Indore? " + result);
    }

    public static void main(String[] args) {
        // Create test traders
        Trader trader1 = new Trader("Manish", "New York");
        Trader trader2 = new Trader("Gourav", "London");
        Trader trader3 = new Trader("Sameer", "Paris");
        Trader trader4 = new Trader("Ankesh", "Indore");

        List<Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Check if any traders are based in Indore
        boolean result = areTradersInCity(traders, "Indore");

        // Logging the result
        logger.info("Main Method Result - Are any traders based in Indore? " + result);
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
