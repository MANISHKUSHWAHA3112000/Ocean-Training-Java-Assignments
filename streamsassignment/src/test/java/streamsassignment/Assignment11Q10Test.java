package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import streamsassignment.Assignment11Q10.Trader;

class Assignment11Q10Test {

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
}
