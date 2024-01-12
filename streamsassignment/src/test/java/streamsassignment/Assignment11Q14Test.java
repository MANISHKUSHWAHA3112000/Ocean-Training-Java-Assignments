package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Assignment11Q14Test {

    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(Assignment11Q14Test.class.getName());

    private Assignment11Q14.Transaction transaction;
    private Assignment11Q14.Trader trader;

    @BeforeEach
    void setUp() {
        trader = new Assignment11Q14.Trader("Manish");
        transaction = new Assignment11Q14.Transaction(trader, 2022, 1000);
    }

    @Test
    void testTransactionToString() {
        String expected = "Transaction details: Trader = Manish, Year = 2022, Value = 1000";
        assertEquals(expected, transaction.toString());
    }

    @Test
    void testTraderDefaultConstructor() {
        Assignment11Q14.Trader defaultTrader = new Assignment11Q14.Trader();
        assertEquals(null, defaultTrader.name);
    }

   

        

    @Test
    void testTraderConstructorWithName() {
        Assignment11Q14.Trader namedTrader = new Assignment11Q14.Trader("John");
        assertEquals("John", namedTrader.name);
    }

    @Test
    void testTransactionConstructor() {
        Assignment11Q14.Transaction newTransaction = new Assignment11Q14.Transaction(trader, 2023, 1500);
        assertEquals("Transaction details: Trader = Manish, Year = 2023, Value = 1500", newTransaction.toString());
    }
}
