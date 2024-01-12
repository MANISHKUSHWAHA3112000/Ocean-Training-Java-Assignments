package PhoneBook;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;



public class PhoneBookTest {
    private PhoneBook phoneBook;
    private Contact contact1;
    private Contact contact2;
    @SuppressWarnings("unused")
	private Contact contact3;

    @Before
    public void setUp() {
        phoneBook = new PhoneBook();
        contact1 = new Contact("John", "Doe", 1234567890, "john@example.com");
        contact2 = new Contact("Jane", "Smith", 9876543, "jane@example.com");
        contact3 = new Contact("Alice", "Johnson", 55555555, "alice@example.com");
    }

    @Test
    public void testAddContact() {
        phoneBook.addContact(contact1);
        List<Contact> contacts = phoneBook.getPhoneBook();
        assertTrue(contacts.contains(contact1));
    }

    @Test
    public void testViewAllContacts() {
        phoneBook.addContact(contact1);
        phoneBook.addContact(contact2);
        List<Contact> contacts = phoneBook.viewAllContacts();
        assertEquals(2, contacts.size());
        assertTrue(contacts.contains(contact1));
        assertTrue(contacts.contains(contact2));
    }

    @Test
    public void testViewContactGivenPhone() {
        phoneBook.addContact(contact1);
        phoneBook.addContact(contact2);

        Contact foundContact = phoneBook.viewContactGivenPhone(1234567890);
        assertEquals(contact1, foundContact);

        Contact nonExistentContact = phoneBook.viewContactGivenPhone(999999999);
        assertNull(nonExistentContact);
    }

    @Test
    public void testRemoveContact() {
        phoneBook.addContact(contact1);
        phoneBook.addContact(contact2);
        
        assertTrue(phoneBook.removeContact(1234567890));
        assertEquals(1, phoneBook.getPhoneBook().size());
        assertFalse(phoneBook.removeContact(1234567890)); // Should return false for a contact that doesn't exist
        assertEquals(1, phoneBook.getPhoneBook().size());
    }
}

