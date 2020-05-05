package model;

import exceptions.WrongPasswordException;

public abstract class User {

	private final long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String eMail;
	private String userName;
	private String password;
	
	public User(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.userName = userName;
		this.password = password;
	}
	
	public void authenticate(String userName, String password) throws WrongPasswordException {
		if (userName.equals(this.userName) && password.equals(this.password)) {
			return;
		} else {
			throw new WrongPasswordException();
		}
	}
	
	public void changeContactInfo(String firstName, String lastName, String phoneNumber, String eMail) {
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}