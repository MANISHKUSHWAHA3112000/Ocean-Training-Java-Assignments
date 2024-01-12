package basicdatastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5 test case for Assignment1Q6.
 */
class Assignment1Q6Test {

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
