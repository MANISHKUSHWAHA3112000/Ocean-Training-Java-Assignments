package streamsassignment;


import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;



public class Assignment11Q15 {
    private static final Logger logger = Logger.getLogger(Assignment11Q15.class.getName());

    Trader trader;
    int year;
    int value;

    public Assignment11Q15(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public static Assignment11Q15 findSmallestValueTransaction(List<Assignment11Q15> transactions) {
        return transactions.stream()
                .min(Comparator.comparingInt(transaction -> transaction.value))
                .orElse(null);
    }

    
    
    public static void main(String[] args) {
        // Example usage in the main method
        Trader trader1 = new Trader("Manish");
        Trader trader2 = new Trader("Aryan");
        Trader trader3 = new Trader("Utsav");

        Assignment11Q15 transaction1 = new Assignment11Q15(trader1, 2022, 1000);
        Assignment11Q15 transaction2 = new Assignment11Q15(trader2, 2022, 800);
        Assignment11Q15 transaction3 = new Assignment11Q15(trader3, 2022, 1200);

        List<Assignment11Q15> transactions = List.of(transaction1, transaction2, transaction3);

        Assignment11Q15 smallestValueTransaction = findSmallestValueTransaction(transactions);

        logger.info("Transaction with the smallest value: " + smallestValueTransaction);
    }

    static class Trader {
        String name;

        public Trader(String name) {
            this.name = name;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Assignment11Q15 that = (Assignment11Q15) obj;
        return year == that.year &&
                value == that.value &&
                trader.equals(that.trader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trader, year, value);
    }

   
}
