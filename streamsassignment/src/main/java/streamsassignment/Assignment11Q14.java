package streamsassignment;



import java.util.logging.Logger;


import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Assignment11Q14 {

    private static final Logger logger = Logger.getLogger(Assignment11Q14.class.getName());

    Trader trader;
    int year;
    int value;
    Assignment11Q14.Transaction transaction;

    public Assignment11Q14(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction details: " +
                "Trader = " + trader.name +
                ", Year = " + year +
                ", Value = " + value;
    }

   

    public static void main(String[] args) {
        // Example usage in the main method
        Trader trader = new Trader("Manish");
        Assignment11Q14 transaction = new Assignment11Q14(trader, 2022, 1000);
        logger.info(transaction.toString());
    }

    static class Trader {
        String name;

        public Trader(String name) {
            this.name = name;
        }

        // Add a default constructor
        public Trader() {
        }
    }

    static class Transaction {
        private Trader trader;
        private int year;
        private int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Transaction details: " +
                    "Trader = " + trader.name +
                    ", Year = " + year +
                    ", Value = " + value;
        }
    }
}
