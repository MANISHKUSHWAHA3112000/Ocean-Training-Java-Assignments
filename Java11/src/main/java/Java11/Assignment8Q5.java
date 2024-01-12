package Java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment8Q5 {

    private static final Logger logger = Logger.getLogger(Assignment8Q5.class.getName());
    private static final String PRICES_FILE = "prices.txt";
    private static final String TOTAL_FILE = "total.txt";

    private final Scanner scanner;

    public Assignment8Q5(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executeOptions() {
        try (Scanner scanner = this.scanner) {
            while (true) {
                logger.info("Select your option (1: Insert New Price, 2: View Purchase Total, 3: Exit)");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        insertNewPrice();
                        break;
                    case 2:
                        viewPurchaseTotal(Path.of(PRICES_FILE));
                        break;
                    case 3:
                        logger.info("Exiting program...");
                        return; // Return instead of System.exit(0)
                    default:
                        logger.info("Invalid option. Please select again.");
                }
            }
        }
    }

    private void insertNewPrice() {
        try {
            Path pricesPath = Path.of(PRICES_FILE);

            do {
                logger.info("Insert price: ");
                double price = getUserInputPrice();

                Files.write(pricesPath, (String.valueOf(price) + System.lineSeparator()).getBytes(),
                        java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);

                logger.info("Price has been saved to the file.");

                logger.info("Do you want to enter the price for more items? (Yes/No): ");
            } while ("Yes".equalsIgnoreCase(scanner.next()));

        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while writing to the file: " + e.getMessage(), e);
        }
    }

    private double getUserInputPrice() {
        while (!scanner.hasNextDouble()) {
            logger.info("Invalid input. Please enter a valid price: ");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextDouble();
    }

    double viewPurchaseTotal(Path pricesPath) {
        try {
            double total = Files.lines(pricesPath)
                    .mapToDouble(Double::parseDouble)
                    .sum();

            Path totalPath = Path.of(TOTAL_FILE);
            Files.write(totalPath, (String.valueOf(total) + System.lineSeparator()).getBytes(),
                    java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.TRUNCATE_EXISTING);

            logger.info("Total Price of all items is: " + total);
            return total;

        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while reading/writing to the file: " + e.getMessage(), e);
            return 0.0;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Assignment8Q5 assignment8Q5 = new Assignment8Q5(scanner);
            assignment8Q5.executeOptions();
        }
    }
}
