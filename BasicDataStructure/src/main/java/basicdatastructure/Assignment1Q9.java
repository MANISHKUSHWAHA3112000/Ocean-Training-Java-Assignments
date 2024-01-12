package basicdatastructure;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class calculates and displays total and average marks for each subject and student.
 */
public final class Assignment1Q9 {

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q9.class.getName());

    /**
     * Default constructor
     */
    private Assignment1Q9() {
    }

    /**
     * Utility class for handling input.
     */
    static class InputUtil {

        // Scanner class for user input
        private static final Scanner scanner = new Scanner(System.in);

        /**
         * Reads an integer from the standard input.
         *
         * @return The integer read from the input.
         */
        static int readInt() {
            return scanner.nextInt();
        }

        /**
         * Closes the scanner to release resources.
         */
        static void closeScanner() {
            scanner.close();
        }
    }

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Number of subjects and students
        final int numSubjects = 3;
        final int numStudents = 3;

        // Arrays to store marks
        final int[][] marks = new int[numStudents][numSubjects];

        // Accepting marks for each student and each subject
        for (int i = 0; i < numStudents; i++) {
            logger.log(Level.INFO, "Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < numSubjects; j++) {
                logger.log(Level.INFO, "Enter marks for Subject " + (char) ('A' + j) + ": ");
                marks[i][j] = InputUtil.readInt();
            }
        }

        // Calculating and logging total and average marks for each subject
        logger.log(Level.INFO, "\nSubject-wise Results:");
        for (int j = 0; j < numSubjects; j++) {
            int subjectTotal = 0;
            for (int i = 0; i < numStudents; i++) {
                subjectTotal += marks[i][j];
            }
            final double subjectAverage = (double) subjectTotal / numStudents;

            logger.log(Level.INFO, "Subject " + (char) ('A' + j) + ":");
            logger.log(Level.INFO, "  Total Marks: " + subjectTotal);
            logger.log(Level.INFO, "  Average Marks: " + subjectAverage);
            logger.log(Level.INFO, "");
        }

        // Calculating and logging total and average marks for each student
        logger.log(Level.INFO, "Student-wise Results:");
        for (int i = 0; i < numStudents; i++) {
            int studentTotal = 0;
            for (int j = 0; j < numSubjects; j++) {
                studentTotal += marks[i][j];
            }
            final double studentAverage = (double) studentTotal / numSubjects;

            logger.log(Level.INFO, "Student " + (i + 1) + ":");
            logger.log(Level.INFO, "  Total Marks: " + studentTotal);
            logger.log(Level.INFO, "  Average Marks: " + studentAverage);
            logger.log(Level.INFO, "");
        }

        // Close the scanner to release resources
        InputUtil.closeScanner();
    }
}
