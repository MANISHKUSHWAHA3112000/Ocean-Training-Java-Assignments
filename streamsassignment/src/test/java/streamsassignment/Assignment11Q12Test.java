package streamsassignment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Assignment11Q12Test {

    @Test
    void testAreTradersInCity() {
        // Create test traders
        Assignment11Q12.Trader trader1 = new Assignment11Q12.Trader("Manish", "New York");
        Assignment11Q12.Trader trader2 = new Assignment11Q12.Trader("Gourav", "London");
        Assignment11Q12.Trader trader3 = new Assignment11Q12.Trader("Sameer", "Paris");
        Assignment11Q12.Trader trader4 = new Assignment11Q12.Trader("Ankesh", "Indore");

        List<Assignment11Q12.Trader> traders = List.of(trader1, trader2, trader3, trader4);

        // Check if any traders are based in Indore
        assertTrue(Assignment11Q12.areTradersInCity(traders, "Indore"));

        // Check if any traders are based in Tokyo (assuming none are)
        assertFalse(Assignment11Q12.areTradersInCity(traders, "Tokyo"));
    }
}
