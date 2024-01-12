package streamsassignment;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Assignment11Q15Test {

    private Assignment11Q15.Trader trader;

    @BeforeEach
    void setUp() {
        trader = new Assignment11Q15.Trader("manish");
    }

    @Test
    void testFindSmallestValueTransaction() {
        Assignment11Q15 transaction1 = new Assignment11Q15(trader, 2022, 1000);
        Assignment11Q15 transaction2 = new Assignment11Q15(trader, 2022, 800);
        Assignment11Q15 transaction3 = new Assignment11Q15(trader, 2022, 1200);

        List<Assignment11Q15> transactions = List.of(transaction1, transaction2, transaction3);

        Assignment11Q15 smallestValueTransaction = Assignment11Q15.findSmallestValueTransaction(transactions);

        assertEquals(transaction2, smallestValueTransaction);
    }
    @Test
    void testFindSmallestValueTransactionWithEmptyList() {
        List<Assignment11Q15> transactions = List.of();
        Assignment11Q15 smallestValueTransaction = Assignment11Q15.findSmallestValueTransaction(transactions);
        assertNull(smallestValueTransaction);
    }
    
    @Test
    void testFindSmallestValueTransactionWithSameValues() {
        Assignment11Q15 transaction1 = new Assignment11Q15(trader, 2022, 1000);
        Assignment11Q15 transaction2 = new Assignment11Q15(trader, 2022, 1000);
        Assignment11Q15 transaction3 = new Assignment11Q15(trader, 2022, 1000);

        List<Assignment11Q15> transactions = List.of(transaction1, transaction2, transaction3);

        Assignment11Q15 smallestValueTransaction = Assignment11Q15.findSmallestValueTransaction(transactions);

        assertEquals(transaction1, smallestValueTransaction);
    }




}
