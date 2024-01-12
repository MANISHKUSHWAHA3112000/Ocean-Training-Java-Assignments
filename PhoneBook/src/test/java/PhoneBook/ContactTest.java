package PhoneBook;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ContactTest {
	private Contact contact;

	@Before
	public void setUp() {
		contact = new Contact("John", "Doe", 1234567890, "john@example.com");
	}

	@Test
	public void testGetFirstName() {
		assertEquals("John", contact.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		contact.setFirstName("Jane");
		assertEquals("Jane", contact.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Doe", contact.getLastName());
	}

	@Test
	public void testSetLastName() {
		contact.setLastName("Smith");
		assertEquals("Smith", contact.getLastName());
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals(1234567890, contact.getPhoneNumber());
	}

	@Test
	public void testSetPhoneNumber() {
		contact.setPhoneNumber(9876543);
		assertEquals(9876543, contact.getPhoneNumber());
	}

	@Test
	public void testGetEmailId() {
		assertEquals("john@example.com", contact.getEmailId());
	}

	@Test
	public void testSetEmailId() {
		contact.setEmailId("jane@example.com");
		assertEquals("jane@example.com", contact.getEmailId());
	}

	@Test
	public void testConstructor() {
		Contact newContact = new Contact("Alice", "Johnson", 9876543, "alice@example.com");
		assertEquals("Alice", newContact.getFirstName());
		assertEquals("Johnson", newContact.getLastName());
		assertEquals(9876543, newContact.getPhoneNumber());
		assertEquals("alice@example.com", newContact.getEmailId());
	}
}


