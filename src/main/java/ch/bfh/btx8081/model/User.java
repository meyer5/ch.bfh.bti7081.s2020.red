package ch.bfh.btx8081.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import ch.bfh.btx8081.exceptions.WrongPasswordException;

@Entity
//@Table(name = "user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public abstract class User {

	
//	No need for ID because username is unique
	@Transient
	private long id;			//cannot be final because of JPA
	
	private String firstName = "";
	private String lastName = "";
	private String phoneNumber = "";
	private String eMail = "";
	@Id
	private String userName = "";
	private String password = "";
	
	// public constructor with no arguments for JPA
	
	public User() {
		
	}
	
	protected User(String firstName, String lastName, String phoneNumber, String eMail, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.userName = userName;
		this.password = password;
	}
	
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
	
	protected User authenticate(String userName, String password) throws WrongPasswordException {
		if (userName.equals(this.userName) && password.equals(this.password)) {
			return this;
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