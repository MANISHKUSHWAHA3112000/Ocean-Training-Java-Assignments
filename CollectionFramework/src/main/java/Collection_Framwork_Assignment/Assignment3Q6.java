package Collection_Framwork_Assignment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

class Chatroom {
    private String name;
    private List<String> messages;
    private Set<String> users;

    public Chatroom(String name) {
        this.name = name;
        this.messages = new LinkedList<>();
        this.users = new HashSet<>();
    }

    // Getters and setters...
    
    

    public void addMessage(String message) {
        messages.add(message);
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(Set<String> users) {
		this.users = users;
	}

	public void addUser(String username) {
        users.add(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    // Other methods...

}

class User {

    private static final Logger logger = Logger.getLogger(Assignment3Q6.class.getName());

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters...
    
    

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
                + lastName + "]";
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static Logger getLogger() {
		return logger;
	}
}

class ChatApp {
	
	private static final Logger logger = Logger.getLogger(Assignment3Q6.class.getName());

    private Map<String, Chatroom> chatrooms = new HashMap<>();
    private Map<String, User> users = new HashMap<>();
    private Set<String> loggedInUsers = new HashSet<>();

    public boolean isChatroomNameValid(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public boolean isUsernameExists(String username) {
        return users.containsKey(username);
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword() != null && user.getPassword().equals(password);
    }

    public void createChatroom(String name) {
        Chatroom chatroom = new Chatroom(name);
        chatrooms.put(name, chatroom);
        logger.info("Chatroom created successfully");
    }

    public void addUser(String chatroomName, User user) {
        if (isUsernameExists(user.getUsername())) {
            logger.info("User already exists");
            return;
        }
        users.put(user.getUsername(), user);
        Chatroom chatroom = chatrooms.get(chatroomName);
        if (chatroom != null) {
            chatroom.addUser(user.getUsername());
        } else {
            Chatroom newchatroom = new Chatroom(chatroomName);
            newchatroom.addUser(user.getUsername());
            chatrooms.put(chatroomName, newchatroom);
        }
        logger.info("User added successfully");
    }

    // Implement other methods...

    public List<String> getChatrooms() {
        return new ArrayList<>(chatrooms.keySet());
    }

    public void login(String loginUsername, String loginPassword) {
        User user = users.get(loginUsername);
        if (user != null && user.getPassword() != null && user.getPassword().equals(loginPassword)) {
            loggedInUsers.add(loginUsername);
            logger.info("User logged in successfully");
        } else {
            logger.info("Invalid username or password. Please try again.");
        }
    }

}

public class Assignment3Q6 {

	private static ChatApp chatApp;
    private static final Logger logger = Logger.getLogger(Assignment3Q6.class.getName());

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int session = 0;
        chatApp = new ChatApp();

        do {
            logger.info("A. Create a chatroom\n" + "B. Add the user\n" + "C. User login\n"
                    + "D. Send a message\n" + "E. Display the messages from a specific chatroom\n"
                    + "F. List down all users belonging to the specified chat room.\n"
                    + "G. Logout\n" + "H. Delete a user\n" + "I. Delete the chat room.\n" + "J. List all chatrooms.\n");

            logger.info("Please enter your option:");
            String option = sc.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    logger.info("Enter Chatroom Name:");
                    String roomName = sc.nextLine();
                    chatApp.createChatroom(roomName);
                    break;

                case "B":
                    logger.info("Username:");
                    String username = sc.nextLine();
                    logger.info("Password:");
                    String password = sc.nextLine();
                    logger.info("First Name:");
                    String firstName = sc.nextLine();
                    logger.info("Last Name:");
                    String lastName = sc.nextLine();
                    User newUser = new User(username, password, firstName, lastName);
                    logger.info("Chatroom Name:");
                    String chatroomName = sc.nextLine();
                    chatApp.addUser(chatroomName, newUser);
                    break;

                case "C":
                    logger.info("Username:");
                    String loginUsername = sc.nextLine();
                    logger.info("Password:");
                    String loginPassword = sc.nextLine();
                    chatApp.login(loginUsername, loginPassword);
                    break;

                // Implement other cases...

                default:
                    logger.info("Invalid option. Please try again.");
                    break;
            }

        } while (session == 0);

        sc.close();
    }
}
