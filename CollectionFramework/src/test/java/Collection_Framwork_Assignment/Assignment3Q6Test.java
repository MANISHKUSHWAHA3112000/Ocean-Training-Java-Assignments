package Collection_Framwork_Assignment;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Assignment3Q6Test {

    private ChatApp chatApp;

    @Before
    public void setUp() {
        chatApp = new ChatApp();
    }

    @Test
    public void testIsChatroomNameValid() {
        assertTrue(chatApp.isChatroomNameValid("validChatroom"));
        assertFalse(chatApp.isChatroomNameValid("invalid@Chatroom"));
        assertFalse(chatApp.isChatroomNameValid("1234"));
    }

    @Test
    public void testIsUsernameExists() {
        User user = new User("testUser", "password", "John", "Doe");
        chatApp.addUser("testRoom", user);
        assertTrue(chatApp.isUsernameExists("testUser"));
        assertFalse(chatApp.isUsernameExists("nonexistentUser"));
    }

    @Test
    public void testAuthenticateUser() {
        User user = new User("testUser", "password", "John", "Doe");
        chatApp.addUser("testRoom", user);
        assertTrue(chatApp.authenticateUser("testUser", "password"));
        assertFalse(chatApp.authenticateUser("testUser", "wrongPassword"));
        assertFalse(chatApp.authenticateUser("nonexistentUser", "password"));
    }

    // Add more test cases for other methods in ChatApp class

}
