package PhoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * phonebook
 */
public class PhoneBook {

	/**
	 * list for contact phonebook
	 */
	private List<Contact> phoneBook = new ArrayList<Contact>();
    
    
    public void setPhoneBook(List<Contact> phoneBook){
        this.phoneBook = phoneBook;
    }
    
    public List<Contact> getPhoneBook(){
        return this.phoneBook;
    }
    
   
    /**
     * @param contactObj
     */
    public void addContact(Contact contactObj){
        this.phoneBook.add(contactObj);
        setPhoneBook(this.phoneBook);
    }

    
    /**
     * @return
     */
    public List<Contact> viewAllContacts(){
        return this.phoneBook;
    }
    
    
    /**
     * @param phoneNumber
     * @return
     */
    public Contact viewContactGivenPhone(long phoneNumber){
        ListIterator<Contact> itr = phoneBook.listIterator();
        while(itr.hasNext())
        {
            //itr.next() -> gives customer object
            Object obj = itr.next();
            Contact c = (Contact)obj;
            long phone = c.getPhoneNumber();
            if(phone==phoneNumber)
            {
                return c;
            }
        }
        return null;
    }
    
    
    /**
     * @param phoneNumber
     * @return
     */
    public boolean removeContact(long phoneNumber){
        ListIterator<Contact> itr = phoneBook.listIterator();
        while(itr.hasNext())
        {
            //itr.next() -> gives customer object
            Object obj = itr.next();
            Contact c = (Contact)obj;
            long phone = c.getPhoneNumber();
            if(phone==phoneNumber)
            {
                itr.remove();
                return true;
            }
        }
        return false;
    }
}
