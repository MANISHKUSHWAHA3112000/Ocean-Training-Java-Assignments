package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Transaction {
    Trader trader;
    int year;
    int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}

class Trader {
    String name;

    public Trader(String name) {
        this.name = name;
    }
}

public class Assignment11Q8 {

    private static final Logger logger = Logger.getLogger(Assignment11Q8.class.getName());

    public static List<Transaction> filterAndSortTransactions(List<Transaction> transactions, int year) {
        return transactions.stream()
                .filter(transaction -> transaction.year == year)
                .sorted(Comparator.comparingInt(transaction -> transaction.value))
                .collect(Collectors.toList());
    }

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
    
    public static void main(String[] args) {
        // Creating sample transactions
        Transaction transaction1 = new Transaction(new Trader("Manish"), 2011, 500);
        Transaction transaction2 = new Transaction(new Trader("Gourav"), 2011, 300);
        Transaction transaction3 = new Transaction(new Trader("Aryan"), 2011, 700);
        Transaction transaction4 = new Transaction(new Trader("Kamlesh"), 2012, 400);

        List<Transaction> transactions = List.of(transaction1, transaction2, transaction3, transaction4);

        // Filtering and sorting transactions for the year 2011
        List<Transaction> result = filterAndSortTransactions(transactions, 2011);

        // Logging the result
        logger.info("Filtered and Sorted Transactions for the year 2011:");
        for (Transaction transaction : result) {
            logger.info("Trader: " + transaction.trader.name + ", Value: " + transaction.value);
        }
    }
}
