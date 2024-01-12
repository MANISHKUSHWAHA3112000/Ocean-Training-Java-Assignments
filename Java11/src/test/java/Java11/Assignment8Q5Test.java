package Java11;



import org.junit.jupiter.api.Test;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Assignment8Q5Test {

	 @Test
	    void testViewPurchaseTotal() {
	        // Create a temporary file for testing
	        try {
	            Path pricesPath = Path.of("temp_prices.txt");
	            Files.write(pricesPath, "10.5\n20.75\n15.0\n".getBytes());

	            Assignment8Q5 assignment = new Assignment8Q5(new Scanner(System.in));
	            double total = assignment.viewPurchaseTotal(pricesPath);

	            assertEquals(46.25, total, 0.001); // Adjust the expected total based on your test case

	            // Clean up the temporary file
	            Files.deleteIfExists(pricesPath);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

