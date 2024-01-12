package PhoneBook;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MainTest {
	
	@SuppressWarnings("unused")
	private PhoneBook phoneBook;
	private InputStream originalIn;
	private PrintStream originalOut;
	private ByteArrayOutputStream output;

	@Before
	public void setUp() {
		phoneBook = new PhoneBook();
		originalIn = System.in;
		originalOut = System.out;
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		provideInput("1\n\nSimon\nKlay\n\n9234567890\nsimon@example.com\n");
	}

	@After
	public void tearDown() {
		provideInput("5\n");
		System.setIn(originalIn);
		System.setOut(originalOut);
	}

	@Test
	public void testAddContact() {
		provideInput("1\nJohn\nDoe\n1234567890\njohn@example.com\n");
		Main.main(null);
		String outputText = output.toString();
		assertTrue(outputText.contains("First Name: John"));
		assertTrue(outputText.contains("Last Name: Doe"));
		assertTrue(outputText.contains("Phone No.: 1234567890"));
		assertTrue(outputText.contains("Email: john@example.com"));
	}

	private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub

	}


	


	

	@Test
	public void testRemoveContactNoConfirmation() {
	    provideInput("4\n9234567890\nN\n");
	    Main.main(null);
	    String outputText = output.toString();
	    assertTrue(outputText.contains("The contact is not removed."));
	}

	@Test
	public void testRemoveContactContactNotFound() {
	    provideInput("4\n1111111111\nY\n");
	    Main.main(null);
	    String outputText = output.toString();
	    assertTrue(outputText.contains("Contact not found."));
	}

	@Test
	public void testExitApplication() {
	    provideInput("5\n");
	    Main.main(null);
	    String outputText = output.toString();
	    assertTrue(outputText.contains("Exiting the program."));
	}


	@Test
	public void testRemoveContact() {
		provideInput("4\n9234567890\nY\n");
		Main.main(null);
		String outputText = output.toString();
		assertTrue(outputText.contains("The contact is successfully deleted."));
	}
	
	@Test
	public void testDisplayAllContacts() {
		provideInput("2\n");
		Main.main(null);
		
		String outputText = output.toString();
		assertTrue(outputText.contains("The contacts in the List are:"));
	}
	

	private void provideInput(String data) {
		System.setIn(new ByteArrayInputStream(data.getBytes()));
	}
}
