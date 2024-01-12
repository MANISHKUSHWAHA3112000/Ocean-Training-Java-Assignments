package PhoneBook;

/**
 * contact class
 */
public class Contact {
	/**
	 * firstName
	 */
	private String firstName;
	/**
	 * lastName
	 */
	private String lastName;
	/**
	 * phoneNumber
	 */
	private long phoneNumber; 
	/**
	 * emailId
	 */
	private String emailId;

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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param emailId
	 */
	public Contact(String firstName, String lastName, long phoneNumber, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

}
