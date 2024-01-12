package streamsassignment;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment11Q8Test {

    @Test
    void testFilterAndSortTransactions() {
        // Create test transactions
        Transaction transaction1 = new Transaction(new Trader("Manish "), 2011, 500);
        Transaction transaction2 = new Transaction(new Trader("Gourav"), 2011, 300);
        Transaction transaction3 = new Transaction(new Trader("Aryan"), 2011, 700);
        Transaction transaction4 = new Transaction(new Trader("Kamlesh"), 2012, 400);

        List<Transaction> transactions = List.of(transaction1, transaction2, transaction3, transaction4);

        // Filter and sort transactions for the year 2011
        List<Transaction> result = Assignment11Q8.filterAndSortTransactions(transactions, 2011);

        // Expected result after sorting: transaction2, transaction1, transaction3
        assertEquals(3, result.size());
        assertEquals(transaction2, result.get(0));
        assertEquals(transaction1, result.get(1));
        assertEquals(transaction3, result.get(2));
    }
}
