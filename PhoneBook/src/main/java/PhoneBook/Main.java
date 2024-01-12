package PhoneBook;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    @SuppressWarnings("resource")
	public static void main(String args[]) {
        // Menu start
        logger.info("Menu");
        logger.info("1.Add Contact");
        logger.info("2.Display all contacts");
        logger.info("3.Search contact by phone ");
        logger.info("4.Remove contact");
        logger.info("5.Exit");
        logger.info("Enter your choice:");

        // Input
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine();
        PhoneBook p = new PhoneBook();

        switch (input) {
            case 1: // Add Contact
                {
                    logger.info("Add a Contact:");
                    logger.info("Enter the First Name:");
                    String firstName = sc.nextLine();
                    logger.info("Enter the Last Name:");
                    String lastName = sc.nextLine();
                    logger.info("Enter the Phone No.:");
                    Long phoneNumber = sc.nextLong();
                    sc.nextLine();
                    logger.info("Enter the Email:");
                    String emailId = sc.nextLine();
                    Contact c = new Contact(firstName, lastName, phoneNumber, emailId);
                    p.addContact(c);
                    break;
                }
            case 2: // Display all contacts
                {
                    logger.info("The contacts in the List are:");
                    List<Contact> phoneBook = p.viewAllContacts();
                    for (Contact obj : phoneBook) {
                        logger.info("First Name: " + obj.getFirstName());
                        logger.info("Last Name: " + obj.getLastName());
                        logger.info("Phone No.: " + obj.getPhoneNumber());
                        logger.info("Email: " + obj.getEmailId());
                    }
                    break;
                }
            case 3: // Search contact by phone
                {
                    logger.info("Enter the Phone number to search contact:");
                    long searchContact = sc.nextLong();
                    sc.nextLine();
                    logger.info("The contact is:");
                    Contact c = p.viewContactGivenPhone(searchContact);
                    logger.info("First Name: " + c.getFirstName());
                    logger.info("Last Name: " + c.getLastName());
                    logger.info("Phone No.: " + c.getPhoneNumber());
                    logger.info("Email: " + c.getEmailId());
                    break;
                }
            case 4: // Remove contact
                {
                    logger.info("Enter the Phone number to remove :");
                    long removePhoneNumber = sc.nextLong();
                    sc.nextLine();
                    logger.info("Do you want to remove the contact (Y/N):");
                    String confirm = sc.nextLine();
                    confirm = confirm.toLowerCase();
                    if (confirm.equals("y")) {
                        boolean deletedContact = p.removeContact(removePhoneNumber);
                        if (deletedContact) {
                            logger.info("The contact is successfully deleted.");
                        }
                    }
                    break;
                }
            default: {
                break;
            }
        }
    }
}
