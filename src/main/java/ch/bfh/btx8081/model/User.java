package ch.bfh.btx8081.model;

import ch.bfh.btx8081.exceptions.WrongPasswordException;

public abstract class User {

	private final long id;
	private String firstName = "";
	private String lastName = "";
	private String phoneNumber = "";
	private String eMail = "";
	private String userName = "";
	private String password = "";
	
	protected User(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.userName = userName;
		this.password = password;
	}
	
	protected void authenticate(String userName, String password) throws WrongPasswordException {
		if (userName.equals(this.userName) && password.equals(this.password)) {
			return;
		} else {
			throw new WrongPasswordException();
		}
	}
	
	protected void changeContactInfo(String firstName, String lastName, String phoneNumber, String eMail) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.seteMail(eMail);
	}
	
//	getters & setters
	
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	protected void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUserName() {
		return userName;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}
	
	
	
}