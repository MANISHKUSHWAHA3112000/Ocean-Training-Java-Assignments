package streamsassignment;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Assignment11Q13Test {

    @Test
    void testPrintTransactionsFromCity() {
        // Redirect logger output to capture log messages
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        Logger logger = Logger.getLogger(Assignment11Q13.class.getName());
        logger.setUseParentHandlers(false);
        Handler handler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                new PrintStream(outputStreamCaptor).println(record.getMessage());
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() throws SecurityException {
            }
        };
        handler.setLevel(Level.INFO);
        logger.addHandler(handler);

        // Create test transactions
        Assignment11Q13.Trader trader1 = new Assignment11Q13.Trader("Manish", "Delhi");
        Assignment11Q13.Trader trader2 = new Assignment11Q13.Trader("Gourav", "Mumbai");
        Assignment11Q13.Trader trader3 = new Assignment11Q13.Trader("Aryan", "Delhi");
        Assignment11Q13.Trader trader4 = new Assignment11Q13.Trader("Sonu", "Kolkata");

        Assignment11Q13.Transaction transaction1 = new Assignment11Q13.Transaction(trader1, 2011, 500);
        Assignment11Q13.Transaction transaction2 = new Assignment11Q13.Transaction(trader2, 2012, 300);
        Assignment11Q13.Transaction transaction3 = new Assignment11Q13.Transaction(trader3, 2011, 700);
        Assignment11Q13.Transaction transaction4 = new Assignment11Q13.Transaction(trader4, 2012, 400);

        List<Assignment11Q13.Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3, transaction4);

        // Call the method to be tested
        Assignment11Q13.printTransactionsFromCity(transactions, "Delhi");

        // Reset logger
        logger.removeHandler(handler);

        // Verify the logged output
     // Verify the logged output
        String expectedOutput = "Transaction Value: 500\nTransaction Value: 700";
        String actualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n").replace("\r", "\n");
        assertEquals(expectedOutput, actualOutput);

    }
}
