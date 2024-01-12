package basicdatastructure;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Assignment1Q6: A class for user login with limited attempts.
 */
public class Assignment1Q6 {

    private int loginAttempts = 0;
    private static final int MAX_ATTEMPTS = 3;

    // Logger for logging messages
    private static final Logger logger = Logger.getLogger(Assignment1Q6.class.getName());

    /**
     * Logs in a user with the given credentials.
     *
     * @param username The user's username.
     * @param password The user's password.
     * @return A message indicating the result of the login attempt.
     */
    public String loginUser(final String username, final String password) {
        // Simplified logic for demonstration purposes
        final String welcomeMessage = "Welcome " + username;
        final String wrongCredentialsMessage = "You have entered wrong credentials. Attempts left: ";

        if ("Ajay".equals(username) && "password".equals(password)) {
            return welcomeMessage;
        }

        loginAttempts++;

        if (loginAttempts >= MAX_ATTEMPTS) {
            return "Contact Admin";
        }

        return wrongCredentialsMessage + (MAX_ATTEMPTS - loginAttempts);
    }
    
    /**
     * Resets the login attempts to zero.
     */
    public void resetAttempts() {
        loginAttempts = 0;
    }


    /**
     * Gets the number of login attempts made.
     *
     * @return The number of login attempts.
     */
    public int getAttemptCount() {
        return loginAttempts;
    }

    /**
     * Gets the maximum allowed login attempts.
     *
     * @return The maximum allowed login attempts.
     */
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    /**
     * Main method to demonstrate user login through the console.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Assignment1Q6 login = new Assignment1Q6();

        performLogin(login, scanner);

        logger.log(Level.INFO, "Exiting the program.");
    }

    /**
     * Performs the user login process.
     *
     * @param login   The Assignment1Q6 instance.
     * @param scanner The Scanner object for user input.
     */
    public static void performLogin(final Assignment1Q6 login, final Scanner scanner) {
        String userId;
        String password;
        String result;

        do {
            logger.log(Level.INFO, "Enter userId");
            userId = scanner.nextLine();

            logger.log(Level.INFO, "Enter password");
            password = scanner.nextLine();

            result = login.loginUser(userId, password);

            logger.log(Level.INFO, result);

            if (login.getAttemptCount() == login.getMaxAttempts()) {
                logger.log(Level.INFO, "Maximum attempts reached. " + result);
                break;
            }
        } while (result.startsWith("You have entered wrong credentials"));
    }

    /**
     * JUnit 5 test case for login with correct credentials.
     */
    @Test
    void testLoginUserWithCorrectCredentials() {
        final Assignment1Q6 login = new Assignment1Q6();
        final String result = login.loginUser("Ajay", "password");
        assertEquals("Welcome Ajay", result);
    }

    /**
     * JUnit 5 test case for login with wrong credentials.
     */
    @Test
    void testLoginUserWithWrongCredentials() {
        final Assignment1Q6 login = new Assignment1Q6();
        final String result = login.loginUser("WrongUser", "WrongPassword");
        assertTrue(result.startsWith("You have entered wrong credentials"));
    }

    /**
     * JUnit 5 test case for login with maximum attempts reached.
     */
    @Test
    void testLoginUserWithMaxAttempts() {
        final Assignment1Q6 login = new Assignment1Q6();
        login.loginUser("WrongUser", "WrongPassword");
        login.loginUser("WrongUser", "WrongPassword");
        final String result = login.loginUser("WrongUser", "WrongPassword");
        assertEquals("Contact Admin", result);
    }

    


    /**
     * JUnit 5 test case for login after successful login (additional case).
     */
    @Test
    void testLoginUserAfterSuccessfulLogin() {
        final Assignment1Q6 login = new Assignment1Q6();
        login.loginUser("WrongUser", "WrongPassword");
        login.loginUser("WrongUser", "WrongPassword");
        final String result = login.loginUser("Ajay", "password");
        assertEquals("Welcome Ajay", result);
    }

    /**
     * JUnit 5 test case for getting the number of login attempts.
     */
    @Test
    void testGetAttemptCount() {
        final Assignment1Q6 login = new Assignment1Q6();
        login.loginUser("WrongUser", "WrongPassword");
        login.loginUser("WrongUser", "WrongPassword");
        assertEquals(2, login.getAttemptCount());
    }

    /**
     * JUnit 5 test case for getting the maximum allowed login attempts.
     */
    @Test
    void testGetMaxAttempts() {
        final Assignment1Q6 login = new Assignment1Q6();
        assertEquals(3, login.getMaxAttempts());
    }
}
