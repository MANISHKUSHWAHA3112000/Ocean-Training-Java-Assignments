package streamsassignment;

import org.junit.jupiter.api.Test;

import streamsassignment.Assignment11Q11.Trader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Assignment11Q11Test {

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
    }

}
