package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import streamsassignment.Assignment11Q9.Trader;

class Assignment11Q9Test {

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
}
