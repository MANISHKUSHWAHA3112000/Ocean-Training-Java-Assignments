package Java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Assignment8Q4 {

    private static final Logger logger = Logger.getLogger(Assignment8Q4.class.getName());

    public static void main(String[] args) {
        // Modify the file path based on your project structure
    	// Modify the file path based on your project structure or provide an absolute path
    	Path filePath = Paths.get("src/main/java/Java11/StudentList.txt");

        try {
            List<String> names = readStudentFile(filePath);

            // Logging example
            logger.log(Level.INFO, "Names of Students: " + names);

            // Print names and count
           logger.info("Names of Students:");
            names.forEach(System.out::println);

           logger.info("\nTotal Count of Students: " + names.size());

        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while reading the file: " + e.getMessage(), e);
        }
    }

    // Add this method to read student names from a file
    public static List<String> readStudentFile(Path filePath) throws IOException {
        return Files.readAllLines(filePath)
                .stream()
                .filter(line -> !line.trim().isEmpty())
                .collect(Collectors.toList());
    }
}
